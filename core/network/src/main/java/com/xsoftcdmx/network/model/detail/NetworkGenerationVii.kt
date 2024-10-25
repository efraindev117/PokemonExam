package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationVii(
    @SerializedName("icons")
    val icons: NetworkIcons? = NetworkIcons(),
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: NetworkUltraSunUltraMoon? = NetworkUltraSunUltraMoon()
)