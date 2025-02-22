package com.example.newpaperapp.data.repository

import com.example.newpaperapp.data.model.NewspaperDetail
import com.example.newpaperapp.data.model.NewspaperItem
import com.example.newpaperapp.network.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewspaperRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getNewspapers(): List<NewspaperItem> {
        return apiService.getNewspapers().newspapers
    }

    suspend fun getNewspaperDetail(url: String): NewspaperDetail {
        return apiService.getNewspaperDetail(url)
    }
}