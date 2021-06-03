package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.data.Playlist
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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
                        .header("Authorization", "TESTING")
                    chain.proceed(requestBuilder.build())
                }
            }

            val interceptor = HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.HEADERS
                it.level = HttpLoggingInterceptor.Level.BODY
            }
            builder.addInterceptor(interceptor)

            return builder.build()
        }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://quipper.github.io/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    fun <T> createService(service: Class<T>): T {
        return  retrofit.create(service)
    }

}

interface Service {
    @GET("native-technical-exam/playlist.json")
    fun listPlaylist(): Call<List<Playlist>>
}