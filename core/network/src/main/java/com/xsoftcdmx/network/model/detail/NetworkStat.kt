package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkStat(
    @SerializedName("base_stat")
    val baseStat: Int? = 0,
    @SerializedName("effort")
    val effort: Int? = 0,
    @SerializedName("stat")
    val stat: NetworkStatX? = NetworkStatX()
)