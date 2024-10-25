package com.xsoftcdmx.datastore.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val url: String,
    val isFavorite: Boolean = false
)


