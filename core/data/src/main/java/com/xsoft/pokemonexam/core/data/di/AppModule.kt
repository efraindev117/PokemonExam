package com.xsoft.pokemonexam.core.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.xsoft.pokemonexam.core.data.repository.PokemonRemoteMediator
import com.xsoftcdmx.datastore.model.ResultEntity
import com.xsoftcdmx.datastore.room.PokemonDatabase
import com.xsoftcdmx.network.api.IApiPokemon
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @OptIn(ExperimentalPagingApi::class)
    @Provides
    @Singleton
    fun provideBeerPager(beerDb: PokemonDatabase, beerApi: IApiPokemon): Pager<Int, ResultEntity> {
        return Pager(
            config = PagingConfig(pageSize = 25),
            remoteMediator = PokemonRemoteMediator(
                db = beerDb,
                api = beerApi
            ),
            pagingSourceFactory = {
                beerDb.dao().pagingSource()
            }
        )
    }
}