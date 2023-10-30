package com.malbyte.haditskalamunalim.data.source.remote.service

import com.malbyte.haditskalamunalim.data.source.remote.models.HaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}{page}{limit}")
    suspend fun getHadits(
        @Path("perawiSlug") perawi: String,
        @Path("page") page: Int,
        @Path("limit") limit: Int = 20
    ): HaditsResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
    suspend fun search(
        @Path("perawiSlug") perawi: String,
        @Path("nomorHadis") nomorHadis: Int
    ): SearchHaditsResponse

}