package com.laine.m.recyclerviewtolistadapter.api

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.covid19api.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface Covid19ApiService {
    @GET("summary")
    suspend fun getSummary(): String
}

object CovidApi {
    val retrofitService: Covid19ApiService by lazy {
        retrofit.create(Covid19ApiService::class.java)
    }
}