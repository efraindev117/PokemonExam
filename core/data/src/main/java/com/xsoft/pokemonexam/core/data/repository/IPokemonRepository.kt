package com.xsoft.pokemonexam.core.data.repository

import com.xsoft.pokemonexam.core.common.Resource
import com.xsoftcdmx.network.model.detail.NetworkPokemonDetail
import kotlinx.coroutines.flow.Flow

interface IPokemonRepository {
    suspend fun toggleFavorite(id: Int, isFavorite: Boolean)
    suspend fun getPokemonDetail(id: Int): Flow<Resource<NetworkPokemonDetail>>
}
