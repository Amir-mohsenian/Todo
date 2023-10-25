package com.photo.mahsa.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.photo.mahsa.db.model.TaskEntity

@Database(
    entities = [
        TaskEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}