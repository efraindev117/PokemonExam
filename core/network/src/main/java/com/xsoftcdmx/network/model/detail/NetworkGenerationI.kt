package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationI(
    @SerializedName("red-blue")
    val redBlue: NetworkRedBlue? = NetworkRedBlue(),
    @SerializedName("yellow")
    val yellow: NetworkYellow? = NetworkYellow()
)