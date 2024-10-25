package com.xsoft.pokemonexam.core.common

interface Mapper<F,T> {
    fun mapFrom(from:F):T
}