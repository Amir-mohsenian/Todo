package com.photo.mahsa.data

import com.photo.mahsa.db.TaskDao
import com.photo.mahsa.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

interface Repository {
    fun loadTasks(): Flow<List<Task>>
}


class RepositoryImp(private val dao: TaskDao) : Repository {
    override fun loadTasks(): Flow<List<Task>> {
        return flowOf(listOf(
            Task(2, "title", "description"),
            Task(3, "title", "description"),
            Task(4, "title", "description"),
            Task(5, "title", "description"),
            Task(6, "title", "description"),
            Task(7, "title", "description"),
        ))
       /* return dao.loadTasks().map {
            it.map { taskEntity ->
                Task(
                    id = taskEntity.id ?: 0L,
                    title = taskEntity.title,
                    desc = taskEntity.desc
                )
            }
        }*/
    }
}