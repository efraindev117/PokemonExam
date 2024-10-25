package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkVersions(
    @SerializedName("generation-i")
    val generationI: NetworkGenerationI? = NetworkGenerationI(),
    @SerializedName("generation-ii")
    val generationIi: NetworkGenerationIi? = NetworkGenerationIi(),
    @SerializedName("generation-iii")
    val generationIii: NetworkGenerationIii? = NetworkGenerationIii(),
    @SerializedName("generation-iv")
    val generationIv: NetworkGenerationIv? = NetworkGenerationIv(),
    @SerializedName("generation-v")
    val generationV: NetworkGenerationV? = NetworkGenerationV(),
    @SerializedName("generation-vi")
    val generationVi: NetworkGenerationVi? = NetworkGenerationVi(),
    @SerializedName("generation-vii")
    val generationVii: NetworkGenerationVii? = NetworkGenerationVii(),
    @SerializedName("generation-viii")
    val generationViii: NetworkGenerationViii? = NetworkGenerationViii()
)