package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkAbility(
    @SerializedName("ability")
    val ability: NetworkAbilityX? = NetworkAbilityX(),
    @SerializedName("is_hidden")
    val isHidden: Boolean? = false,
    @SerializedName("slot")
    val slot: Int? = 0
)