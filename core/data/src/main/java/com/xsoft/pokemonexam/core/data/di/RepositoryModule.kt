package com.xsoft.pokemonexam.core.data.di

import com.xsoft.pokemonexam.core.data.repository.IPokemonRepository
import com.xsoft.pokemonexam.core.data.repository.PokemonRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): IPokemonRepository
}