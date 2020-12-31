package com.appserba.app.data.repository

import com.appserba.app.data.model.ActionState
import com.appserba.app.data.model.Manga
import com.appserba.app.data.remote.MangaService
import com.appserba.app.data.remote.RetrofitApi
import retrofit2.await

class MangaRepository {
    private val mangaService: MangaService by lazy { RetrofitApi.mangaService() }

    suspend fun listManga() : ActionState<List<Manga>> {
       return try {
            val list = mangaService.listManga().await()
            ActionState(list.manga_list)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailManga(url: String) : ActionState<Manga> {
        return try {
            val list = mangaService.detailManga(url).await()
            ActionState(list.manga_list.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchManga(query: String) : ActionState<List<Manga>> {
       return try {
            val list = mangaService.searchManga(query).await()
            ActionState(list.manga_list)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}