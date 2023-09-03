package com.photo.mahsa.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photo")
data class PhotoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    @ColumnInfo("unsplash_id")
    val unsplashId: String,
    val url: String,
    val isFav: Boolean,
)
