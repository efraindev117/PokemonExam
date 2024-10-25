package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkType(
    @SerializedName("slot")
    val slot: Int? = 0,
    @SerializedName("type")
    val type: NetworkTypeX? = NetworkTypeX()
)