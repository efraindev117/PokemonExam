package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationV(
    @SerializedName("black-white")
    val blackWhite: NetworkBlackWhite? = NetworkBlackWhite()
)