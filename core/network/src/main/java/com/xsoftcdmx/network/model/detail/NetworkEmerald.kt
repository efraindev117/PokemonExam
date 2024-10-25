package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkEmerald(
    @SerializedName("front_default")
    val frontDefault: String? = "",
    @SerializedName("front_shiny")
    val frontShiny: String? = ""
)