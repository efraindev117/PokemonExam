package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkVersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int? = 0,
    @SerializedName("move_learn_method")
    val moveLearnMethod: NetworkMoveLearnMethod? = NetworkMoveLearnMethod(),
    @SerializedName("version_group")
    val versionGroup: NetworkVersionGroup? = NetworkVersionGroup()
)