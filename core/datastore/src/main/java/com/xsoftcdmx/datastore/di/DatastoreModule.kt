package com.xsoftcdmx.datastore.di

import android.content.Context
import androidx.paging.ExperimentalPagingApi
import androidx.room.Room
import com.xsoftcdmx.datastore.room.IPokemonDao
import com.xsoftcdmx.datastore.room.PokemonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatastoreModule {

    @Provides
    @Singleton
    fun provideBeerDatabase(@ApplicationContext context: Context): PokemonDatabase {
        return Room.databaseBuilder(
            context,
            PokemonDatabase::class.java,
            "pokemon.db"
        ).build()
    }

    @Provides
    fun providePokemonDao(db: PokemonDatabase): IPokemonDao {
        return db.dao()
    }

}