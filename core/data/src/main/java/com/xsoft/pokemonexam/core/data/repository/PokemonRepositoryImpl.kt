package com.xsoft.pokemonexam.core.data.repository

import com.xsoft.pokemonexam.core.common.BaseRepository
import com.xsoft.pokemonexam.core.common.Resource
import com.xsoftcdmx.datastore.room.IPokemonDao
import com.xsoftcdmx.network.api.IApiPokemon
import com.xsoftcdmx.network.model.detail.NetworkPokemonDetail
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val dao: IPokemonDao,
    private val api: IApiPokemon
) : IPokemonRepository, BaseRepository() {

    override suspend fun toggleFavorite(id: Int, isFavorite: Boolean) {
        dao.updateFavoriteStatus(id, isFavorite)
    }

    override suspend fun getPokemonDetail(id: Int): Flow<Resource<NetworkPokemonDetail>> =
        safeApiCall {
            api.getPokemonDetail(id)
        }
}