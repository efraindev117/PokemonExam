package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkGenerationIii(
    @SerializedName("emerald")
    val emerald: NetworkEmerald? = NetworkEmerald(),
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: NetworkFireredLeafgreen? = NetworkFireredLeafgreen(),
    @SerializedName("ruby-sapphire")
    val rubySapphire: NetworkRubySapphire? = NetworkRubySapphire()
)