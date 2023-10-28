package com.photo.mahsa.db

import androidx.room.Dao
import androidx.room.Query
import com.photo.mahsa.db.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {

   @Query("SELECT * FROM task ")
   fun loadTasks(): Flow<List<TaskEntity>>
}