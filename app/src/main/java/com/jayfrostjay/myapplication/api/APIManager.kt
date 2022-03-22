package com.jayfrostjay.myapplication.api

import com.jayfrostjay.myapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class APIManager {

    private val httpClient: OkHttpClient
        get() {
            val builder = OkHttpClient.Builder().also {
                it.addInterceptor { chain ->
                    val requestBuilder = chain.request().newBuilder()
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
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient)
        .build()

    fun <T> createService(service: Class<T>): T {
        return  retrofit.create(service)
    }

}