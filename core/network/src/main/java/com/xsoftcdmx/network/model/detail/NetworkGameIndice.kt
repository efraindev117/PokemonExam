package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGameIndice(
    @SerializedName("game_index")
    val gameIndex: Int? = 0,
    @SerializedName("version")
    val version: NetworkVersion? = NetworkVersion()
)