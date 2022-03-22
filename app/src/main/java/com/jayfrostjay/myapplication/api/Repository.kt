package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.data.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(
    private val service: APIService
){

    fun getPlaylist(completion: ((List<Playlist>?) -> Unit)) {
        service.listPlaylist().also {
            it.enqueue(object : Callback<List<Playlist>> {
                override fun onResponse(
                    call: Call<List<Playlist>>,
                    response: Response<List<Playlist>>
                ) {
                    completion.invoke(response.body())
                }
                override fun onFailure(call: Call<List<Playlist>>, t: Throwable) { }
            })
        }

    }
}