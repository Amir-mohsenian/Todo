package com.photo.mahsa.data

import com.photo.mahsa.db.TaskDao
import com.photo.mahsa.db.model.TaskEntity
import com.photo.mahsa.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

interface Repository {
    fun loadTasks(): Flow<List<Task>>

    suspend fun addTask(task: Task): Boolean

    suspend fun removeTask(task: Task): Boolean

    suspend fun updateTask(task: Task)
}


class RepositoryImp(private val dao: TaskDao) : Repository {
    override fun loadTasks(): Flow<List<Task>> {
        return dao.loadTasks().map { list ->
            list.map { taskEntity ->
                Task(
                    id = taskEntity.id ?: -1L,
                    title = taskEntity.title ?: "",
                    desc = taskEntity.desc ?: ""
                )
            }
        }
    }

    override suspend fun addTask(task: Task): Boolean {
        return dao.insertTask(TaskEntity(title = task.title, desc = task.desc)) != -1L
    }

    override suspend fun removeTask(task: Task): Boolean {
        TODO("Not yet implemented")
    }

    override suspend fun updateTask(task: Task) {
        dao.updateTask(TaskEntity(task.id, task.title, task.desc))
    }
}