package com.xsoftcdmx.list_detail.composable

import android.annotation.SuppressLint

fun getPokemonTypeEmoji(type: String?): String {
    val pokemonTypeEmojiMap = mapOf(
        "fire" to "🔥",
        "water" to "💧",
        "grass" to "🌿",
        "electric" to "⚡",
        "ice" to "❄️",
        "fighting" to "🥊",
        "poison" to "☠️",
        "ground" to "🌍",
        "flying" to "\uD83D\uDCA8",
        "psychic" to "🔮",
        "bug" to "🐛",
        "rock" to "🪨",
        "ghost" to "👻",
        "dragon" to "🐉",
        "dark" to "🌑",
        "steel" to "⚙️",
        "fairy" to "✨"
    )
    return pokemonTypeEmojiMap[type?.lowercase()] ?: ""
}

@SuppressLint("DefaultLocale")
fun convertHeightToMeters(heightInDecimetres: Int): String {
    val heightInMeters = heightInDecimetres / 10.0
    return String.format("%.2f m", heightInMeters)
}

@SuppressLint("DefaultLocale")
fun convertWeightToKilograms(weightInHectograms: Int): String {
    val weightInKilograms = weightInHectograms / 10.0
    return String.format("%.2f kg", weightInKilograms)
}