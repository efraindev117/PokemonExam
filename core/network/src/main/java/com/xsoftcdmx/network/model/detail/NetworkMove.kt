package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkMove(
    @SerializedName("move")
    val move: NetworkMoveX? = NetworkMoveX(),
    @SerializedName("version_group_details")
    val versionGroupDetails: List<NetworkVersionGroupDetail>? = listOf()
)