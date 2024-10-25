package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationVi(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: NetworkOmegarubyAlphasapphire? = NetworkOmegarubyAlphasapphire(),
    @SerializedName("x-y")
    val xY: NetworkXY? = NetworkXY()
)