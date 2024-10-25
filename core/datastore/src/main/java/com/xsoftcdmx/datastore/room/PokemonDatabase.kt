package com.xsoftcdmx.datastore.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xsoftcdmx.datastore.model.ResultEntity


@Database(
    entities = [ResultEntity::class],
    version = 1
)
abstract class PokemonDatabase : RoomDatabase() {
    abstract fun dao(): IPokemonDao
}