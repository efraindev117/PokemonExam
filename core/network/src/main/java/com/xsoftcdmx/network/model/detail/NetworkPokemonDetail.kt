package com.xsoftcdmx.network.model.detail


import com.google.gson.annotations.SerializedName

data class NetworkPokemonDetail(
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("abilities")
    val abilities: List<NetworkAbility>? = listOf(),
    @SerializedName("base_experience")
    val baseExperience: Int? = 0,
    @SerializedName("cries")
    val cries: NetworkCries? = NetworkCries(),
    @SerializedName("forms")
    val forms: List<NetworkForm>? = listOf(),
    @SerializedName("game_indices")
    val gameIndices: List<NetworkGameIndice>? = listOf(),
    @SerializedName("height")
    val height: Int? = 0,
    @SerializedName("held_items")
    val heldItems: List<Any>? = listOf(),
    @SerializedName("is_default")
    val isDefault: Boolean? = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String? = "",
    @SerializedName("moves")
    val moves: List<NetworkMove>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("order")
    val order: Int? = 0,
    @SerializedName("past_abilities")
    val pastAbilities: List<Any>? = listOf(),
    @SerializedName("past_types")
    val pastTypes: List<Any>? = listOf(),
    @SerializedName("species")
    val species: NetworkSpecies? = NetworkSpecies(),
    @SerializedName("sprites")
    val sprites: NetworkSprites? = NetworkSprites(),
    @SerializedName("stats")
    val stats: List<NetworkStat>? = listOf(),
    @SerializedName("types")
    val types: List<NetworkType>? = listOf(),
    @SerializedName("weight")
    val weight: Int? = 0
)