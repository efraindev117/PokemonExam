package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationIi(
    @SerializedName("crystal")
    val crystal: NetworkCrystal? = NetworkCrystal(),
    @SerializedName("gold")
    val gold: NetworkGold? = NetworkGold(),
    @SerializedName("silver")
    val silver: NetworkSilver? = NetworkSilver()
)