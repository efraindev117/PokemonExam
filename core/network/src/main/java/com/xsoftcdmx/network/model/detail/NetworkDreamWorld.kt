package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkDreamWorld(
    @SerializedName("front_default")
    val frontDefault: String? = "",
    @SerializedName("front_female")
    val frontFemale: Any? = Any()
)