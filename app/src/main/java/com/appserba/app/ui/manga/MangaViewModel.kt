package com.appserba.app.ui.manga

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.appserba.app.data.model.ActionState
import com.appserba.app.data.model.Manga
import com.appserba.app.data.repository.MangaRepository
import kotlinx.coroutines.launch

class MangaViewModel : ViewModel() {
    val repo: MangaRepository by lazy { MangaRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Manga>>()
    val detailResp = MutableLiveData<Manga>()
    val searchResp = MutableLiveData<List<Manga>>()

    val url = MutableLiveData("")
    val query = MutableLiveData("")

    fun listManga() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listManga()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }

    fun detailManga(url: String? = this.url.value) {
        url?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.detailManga(it)
                actionState.value = resp
                detailResp.value = resp.data
                loading.value = false
            }
        }
    }

    fun searchManga(query: String? = this.query.value) {
        query?.let {
            viewModelScope.launch {
                loading.value = true
                val resp = repo.searchManga(it)
                actionState.value = resp
                searchResp.value = resp.data
                loading.value = false
            }
        }
    }
}