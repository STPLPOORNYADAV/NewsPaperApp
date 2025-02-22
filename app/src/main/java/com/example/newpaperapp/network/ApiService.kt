package com.example.newpaperapp.network

import com.example.newpaperapp.data.model.NewspaperDetail
import com.example.newpaperapp.data.model.NewspaperResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiService {
    @GET("newspapers.json")
    suspend fun getNewspapers(): NewspaperResponse

    @GET
    suspend fun getNewspaperDetail(@Url url: String): NewspaperDetail
}