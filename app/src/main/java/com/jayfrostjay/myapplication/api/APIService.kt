package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.data.Playlist
import retrofit2.Call
import retrofit2.http.GET

interface APIService {
    @GET("video-player-api")
    fun listPlaylist(): Call<List<Playlist>>
}