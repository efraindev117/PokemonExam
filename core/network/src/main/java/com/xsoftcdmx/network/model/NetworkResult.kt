package com.xsoftcdmx.network.model

import com.google.gson.annotations.SerializedName

data class NetworkResult(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
) {
    fun pokemonId(): Int {
        return url.trimEnd('/').substringAfterLast('/').toInt()
    }
}
