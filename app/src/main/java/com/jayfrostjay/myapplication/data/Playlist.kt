package com.jayfrostjay.myapplication.data

import com.google.gson.annotations.SerializedName

data class Playlist(
    @SerializedName("title") val title: String? = null,
    @SerializedName("presenter_name") val presenterName: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("thumbnail_url") val thumbnailUrl: String? = null,
    @SerializedName("video_url") val videoUrl: String? = null,
    @SerializedName("video_duration") val videoDuration: Int? = null
)