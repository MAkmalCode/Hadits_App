package com.malbyte.haditskalamunalim.data.repository

import com.malbyte.haditskalamunalim.data.source.remote.models.HaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse

interface HaditsRepository{
    suspend fun getPerawi(): PerawiResponse

    suspend fun getHadits(
        perawi: String,
        page: Int = 1,
        limit: Int = 20
    ): HaditsResponse

    suspend fun search(
        perawi: String,
        nomorHadis: Int
    ): SearchHaditsResponse
}