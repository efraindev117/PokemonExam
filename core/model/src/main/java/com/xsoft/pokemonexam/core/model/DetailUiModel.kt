package com.xsoft.pokemonexam.core.model

data class PokemonDetail(
    val id: Int?,
    val height: Int?,
    val name: String?,
    val order: Int?,
    val sprites: Sprites?,
    val weight: Int?,
    val types: List<Type>? = listOf(),
){
    fun pathSprite(): String {
        return BuildConfig.SPRITE_URL + id + ".png"
    }
}

data class Sprites(
    val back_default: String? = "",
    val back_female: Any? = null,
    val back_shiny: String? = "",
    val back_shiny_female: Any? = null,
    val front_default: String? = "",
    val front_female: Any? = null,
    val front_shiny: String? = "",
    val front_shiny_female: Any? = null
)

data class Type(
    val slot: Int?,
    val type: TypeX = TypeX()
)

data class TypeX(
    val name: String? = "",
    val url: String? = ""
)

