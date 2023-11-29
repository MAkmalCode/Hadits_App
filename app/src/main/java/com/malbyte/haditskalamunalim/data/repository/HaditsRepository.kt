package com.malbyte.haditskalamunalim.data.repository

import androidx.paging.PagingData
import com.malbyte.haditskalamunalim.data.source.remote.models.Item
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse
import kotlinx.coroutines.flow.Flow

interface HaditsRepository{
    suspend fun getPerawi(): PerawiResponse

    fun getHadits(
        perawiSlug: String,
        perawiName: (String) -> Unit
    ): Flow<PagingData<Item>>

    suspend fun search(
        perawi: String,
        nomorHadis: Int,
    ): SearchHaditsResponse
}