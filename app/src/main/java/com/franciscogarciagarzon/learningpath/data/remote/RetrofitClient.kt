package com.franciscogarciagarzon.learningpath.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {

    private const val BASE_URL = "https://pokeapi.co/api/v2/"
    private val gsonConverter = GsonConverterFactory.create()
    private val httpLogger = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(httpLogger).build()
    private val retrofitBuilder = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(gsonConverter)
        .client(okHttpClient)
        .build()

    val pokeService: PokeApi by lazy {
        retrofitBuilder.create(PokeApi::class.java)
    }

}