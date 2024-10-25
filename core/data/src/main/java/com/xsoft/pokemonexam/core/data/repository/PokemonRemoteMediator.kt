package com.xsoft.pokemonexam.core.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.xsoft.pokemonexam.core.data.mapper.asEntity
import com.xsoftcdmx.datastore.model.ResultEntity
import com.xsoftcdmx.datastore.room.PokemonDatabase
import com.xsoftcdmx.network.api.IApiPokemon
import java.io.IOException


@OptIn(ExperimentalPagingApi::class)
class PokemonRemoteMediator(
    private val api: IApiPokemon,
    private val db: PokemonDatabase
) : RemoteMediator<Int, ResultEntity>() {

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ResultEntity>
    ): MediatorResult {
        return try {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> 0
                LoadType.PREPEND -> return MediatorResult.Success(
                    endOfPaginationReached = true
                )

                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()
                    lastItem?.id ?: return MediatorResult.Success(
                        endOfPaginationReached = true
                    )
                }
            }

            val response = api.getPokemon(
                limit = state.config.pageSize,
                offset = loadKey
            ).body()?.results ?: emptyList()

            val pokemonEntities = response.map { networkResult ->
                val id = networkResult!!.pokemonId()
                val existingEntity = db.dao().getById(id)

                ResultEntity(
                    id = id,
                    name = networkResult!!.name,
                    url = networkResult.url,
                    isFavorite = existingEntity?.isFavorite ?: false
                )
            }


            db.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    db.dao().clearAll()
                }
                db.dao().upsertAll(pokemonEntities)
            }

            MediatorResult.Success(
                endOfPaginationReached = response!!.isEmpty()
            )

        } catch (e: IOException) {
            MediatorResult.Error(e)
        }
    }
}