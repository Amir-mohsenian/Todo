package com.photo.mahsa.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.photo.mahsa.db.model.PhotoEntity

@Database(
    entities = [
        PhotoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun photoDao(): PhotoDao
}