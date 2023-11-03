package com.photo.mahsa.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.photo.mahsa.db.model.TaskEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
   @Insert
   suspend fun insertTask(taskEntity: TaskEntity): Long

   @Update
   suspend fun updateTask(taskEntity: TaskEntity)

   @Query("SELECT * FROM task ")
   fun loadTasks(): Flow<List<TaskEntity>>
}