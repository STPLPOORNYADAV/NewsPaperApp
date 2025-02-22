package com.example.newpaperapp.data.model

import com.google.gson.annotations.SerializedName

data class NewspaperDetail(
    @SerializedName("place_of_publication") val placeOfPublication: String,
    @SerializedName("lccn") val lccn: String,
    @SerializedName("start_year") val startYear: String,
    @SerializedName("place") val place: List<String>,
    @SerializedName("name") val name: String,
    @SerializedName("publisher") val publisher: String,
    @SerializedName("url") val url: String,
    @SerializedName("end_year") val endYear: String,
    @SerializedName("issues") val issues: List<Issue>
)

data class Issue(
    @SerializedName("url") val url: String,
    @SerializedName("date_issued") val dateIssued: String
)

