package com.malbyte.haditskalamunalim.data.repository

import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface

class MainRepository(private val apiInterface: ApiInterface) {

    suspend fun getPerawi() = apiInterface.getPerawi()
    suspend fun getHadits(perawi: String, page: Int) = apiInterface.getHadits(perawi, page)
    suspend fun search(perawi: String, noHadits: Int) = apiInterface.search(perawi, noHadits)
}