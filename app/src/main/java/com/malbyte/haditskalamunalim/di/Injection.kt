package com.malbyte.haditskalamunalim.di

import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private const val BASE_URL = "https://hadis-api-id.vercel.app/"
    fun provideApi() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInterface::class.java)
}