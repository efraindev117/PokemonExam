package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkOther(
    @SerializedName("dream_world")
    val dreamWorld: NetworkDreamWorld? = NetworkDreamWorld(),
    @SerializedName("home")
    val home: NetworkHome? = NetworkHome(),
    @SerializedName("official-artwork")
    val officialArtwork: NetworkOfficialArtwork? = NetworkOfficialArtwork(),
    @SerializedName("showdown")
    val showdown: NetworkShowdown? = NetworkShowdown()
)