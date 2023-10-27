package com.malbyte.haditskalamunalim.data.source.remote.models


import com.google.gson.annotations.SerializedName

data class SearchHaditsResponse(
    @SerializedName("arab")
    val arab: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number")
    val number: Int,
    @SerializedName("slug")
    val slug: String
)