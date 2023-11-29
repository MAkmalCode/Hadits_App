package com.malbyte.haditskalamunalim.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.malbyte.haditskalamunalim.data.paging.HaditsPagingSource
import com.malbyte.haditskalamunalim.data.source.remote.models.Item
import com.malbyte.haditskalamunalim.data.source.remote.models.PerawiResponse
import com.malbyte.haditskalamunalim.data.source.remote.models.SearchHaditsResponse
import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class HaditsrepositoryImpl(private val haditsApi: ApiInterface) : HaditsRepository {

    override suspend fun getPerawi(): PerawiResponse {
        return haditsApi.getPerawi()
    }

    override fun getHadits(
        perawiSlug: String,
        perawiName: (String) -> Unit
    ): Flow<PagingData<Item>> =
        Pager(
            config = PagingConfig(
                pageSize = 20
            ),
            pagingSourceFactory = {
                HaditsPagingSource(
                    haditsApi,
                    perawiSlug,
                    perawiName
                )
            }
        ).flow.flowOn(Dispatchers.Default)

    override suspend fun search(perawi: String, nomorHadis: Int): SearchHaditsResponse {
        return haditsApi.search(perawi, nomorHadis)
    }

}