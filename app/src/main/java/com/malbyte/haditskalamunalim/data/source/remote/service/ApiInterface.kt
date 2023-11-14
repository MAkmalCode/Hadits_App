package com.malbyte.haditskalamunalim.data.source.remote.service

import com.malbyte.haditskalamunalim.data.source.remote.models.HaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("hadith")
    suspend fun getPerawi(): PerawiResponse

    @GET("hadith/{perawiSlug}")
    suspend fun getHadits(
        @Path("perawiSlug") perawi: String,
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 20
    ): HaditsResponse

    @GET("hadith/{perawiSlug}/{nomorHadis}")
    suspend fun search(
        @Path("perawiSlug") perawi: String,
        @Path("nomorHadis") nomorHadis: Int
    ): SearchHaditsResponse

}