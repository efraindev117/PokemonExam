package com.xsoftcdmx.network.model

import com.google.gson.annotations.SerializedName

data class NetworkPokemonRs(
    @SerializedName("count")
    val count: Int? = 0,
    @SerializedName("next")
    val next: String? = "",
    @SerializedName("previous")
    val previous: Any? = Any(),
    @SerializedName("results")
    val results: List<NetworkResult?>? = listOf()
)
