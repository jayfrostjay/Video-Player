package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.data.Playlist
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class Repository(
    private val service: Service
){

    fun getPlaylist(completion: ((List<Playlist>?) -> Unit)) {
        service.listPlaylist().also {
            it.enqueue(object : Callback<List<Playlist>> {
                override fun onResponse(
                    call: Call<List<Playlist>>,
                    response: Response<List<Playlist>>
                ) {

                    Timber.d("TESTING: ${response}")
                    completion.invoke(response.body())
                }

                override fun onFailure(call: Call<List<Playlist>>, t: Throwable) {

                }
            })
        }

    }

}