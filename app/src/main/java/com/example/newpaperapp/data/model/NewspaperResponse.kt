package com.example.newpaperapp.data.model

import com.google.gson.annotations.SerializedName

data class NewspaperResponse(
    @SerializedName("newspapers") val newspapers: List<NewspaperItem>
)

data class NewspaperItem(
    val title: String,
    val url: String,
    val state: String
)
