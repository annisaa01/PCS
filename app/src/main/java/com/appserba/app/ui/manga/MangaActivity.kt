package com.appserba.app.ui.manga

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.appserba.app.R

class MangaActivity : AppCompatActivity() {

    companion object {
        const val OPEN_MANGA = "open_manga"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manga)
    }
}