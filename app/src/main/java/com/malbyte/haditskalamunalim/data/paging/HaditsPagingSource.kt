package com.malbyte.haditskalamunalim.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.malbyte.haditskalamunalim.data.source.remote.models.Item
import com.malbyte.haditskalamunalim.data.source.remote.service.ApiInterface

class HaditsPagingSource(
    val apiService: ApiInterface,
    val perawiSlug: String,
    val perawiName : (String) -> Unit,

): PagingSource<Int, Item>() {
    override fun getRefreshKey(state: PagingState<Int, Item>): Int? {
        return state.anchorPosition?.let {anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.prevKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Item> {
        return try {
            val page = params.key ?: 1
            val response = apiService.getHadits(perawiSlug, page)
            perawiName(response.name)
            LoadResult.Page(
                data = response.items,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.items.isEmpty()) null else page.plus(1)
            )
        }catch (e :Exception){
            LoadResult.Error(e)
        }
    }
}