package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.data.Playlist
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


class ApiService {

    private val httpClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder().also {
                it.addInterceptor { chain ->
                    val requestBuilder = chain.request().newBuilder()
                        .header("AUTHORIZATION", "")

                    chain.proceed(requestBuilder.build())
                }
            }

            return builder.build()
        }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://quipper.github.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> createService(service: Class<T>): T {
        return  retrofit.create(service)
    }

}

interface Service {
    @GET("native-technical-exam/playlist.json")
    fun listPlaylist(): Call<List<Playlist>>
}