package com.malbyte.haditskalamunalim.data.repository

import com.malbyte.haditskalamunalim.data.source.remote.models.HaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface

class HaditsrepositoryImpl(val haditsApi: ApiInterface) : HaditsRepository{

    override suspend fun getPerawi(): PerawiResponse {
        return haditsApi.getPerawi()
    }

    override suspend fun getHadits(perawi: String, page: Int, limit: Int): HaditsResponse {
        return haditsApi.getHadits(perawi, page, limit)
    }

    override suspend fun search(perawi: String, nomorHadis: Int): SearchHaditsResponse {
        return haditsApi.search(perawi, nomorHadis)
    }

}