package com.photo.mahsa.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val title: String? = null,
    val desc: String? = null
)
