package com.malbyte.haditskalamunalim.data.source.remote.models


import com.google.gson.annotations.SerializedName

data class HaditsResponse(
    @SerializedName("items")
    val items: List<Item>,
    @SerializedName("name")
    val name: String,
    @SerializedName("pagination")
    val pagination: Pagination,
    @SerializedName("slug")
    val slug: String,
    @SerializedName("total")
    val total: Int
)