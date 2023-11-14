package com.malbyte.haditskalamunalim.di

import com.malbyte.haditskalamunalim.data.repository.HaditsRepository
import com.malbyte.haditskalamunalim.data.repository.HaditsrepositoryImpl
import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface AppModule {
    val haditsApi: ApiInterface
    val haditsRepository: HaditsRepository
}

class AppModuleImpl : AppModule {
    override val haditsApi: ApiInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://hadis-api-id.vercel.app/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
    }

    override val haditsRepository: HaditsRepository by lazy {
        HaditsrepositoryImpl(haditsApi)
    }
}