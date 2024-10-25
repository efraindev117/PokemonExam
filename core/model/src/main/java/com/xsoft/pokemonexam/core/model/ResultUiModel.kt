package com.xsoft.pokemonexam.core.model


data class ResultUiModel(
    val id: Int = 0,
    val name: String = "",
    val url: String = "",
    var isFavorite: Boolean = false
) {
    fun pathSprite(): String {
        return BuildConfig.SPRITE_URL + id + ".png"
    }
}
