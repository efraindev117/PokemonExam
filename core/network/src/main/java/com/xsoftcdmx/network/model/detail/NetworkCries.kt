package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkCries(
    @SerializedName("latest")
    val latest: String? = "",
    @SerializedName("legacy")
    val legacy: String? = ""
)