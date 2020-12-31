package com.appserba.app.data.remote

import com.appserba.app.data.model.MangaList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaService {
    @GET("/")
    fun listManga() : Call<MangaList>

    @GET("detail/")
    fun detailManga(@Query("url")url: String) : Call<MangaList>

    @GET("search/")
    fun searchManga(@Query("q")query: String) : Call<MangaList>
}