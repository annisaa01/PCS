package com.appserba.app.ui.manga

import android.content.Context
import android.content.Intent
import androidx.databinding.ViewDataBinding
import com.appserba.app.R
import com.appserba.app.data.model.Manga
import com.appserba.app.databinding.ItemMangaBinding
import com.appserba.app.ui.base.BaseAdapter
import com.bumptech.glide.Glide

class MangaAdapter(val context: Context) : BaseAdapter<Manga>(R.layout.item_manga) {
    override fun onBind(binding: ViewDataBinding?, data: Manga) {
        val nBinding = binding as ItemMangaBinding
        Glide.with(context).load(data.thumb).into(nBinding.itemThumb)
    }

    override fun onClick(binding: ViewDataBinding?, data: Manga) {
        val intent = Intent(context, MangaActivity:: class.java)
        intent.putExtra(MangaActivity.OPEN_MANGA, data)
        context.startActivity(intent)
    }
}