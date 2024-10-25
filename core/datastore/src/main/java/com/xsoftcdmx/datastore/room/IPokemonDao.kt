package com.xsoftcdmx.datastore.room

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.xsoftcdmx.datastore.model.ResultEntity

@Dao
interface IPokemonDao {
    @Upsert
    suspend fun upsertAll(beers: List<ResultEntity>)

    @Query("SELECT * FROM ResultEntity WHERE id = :id LIMIT 1")
    suspend fun getById(id: Int): ResultEntity?

    @Query("SELECT * FROM resultEntity")
    fun pagingSource(): PagingSource<Int, ResultEntity>

    @Query("DELETE FROM ResultEntity")
    suspend fun clearAll()

    // Actualizar el estado de favorito
    @Query("UPDATE ResultEntity SET isFavorite = :isFavorite WHERE id = :id")
    suspend fun updateFavoriteStatus(id: Int, isFavorite: Boolean)
}