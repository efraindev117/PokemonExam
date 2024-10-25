package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: NetworkDiamondPearl? = NetworkDiamondPearl(),
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: NetworkHeartgoldSoulsilver? = NetworkHeartgoldSoulsilver(),
    @SerializedName("platinum")
    val platinum: NetworkPlatinum? = NetworkPlatinum()
)