package com.photo.mahsa.data

import com.photo.mahsa.model.Task
import com.photo.mahsa.network.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface Repository {
    fun loadTasks(): Flow<Task>
}


class RepositoryImp(
) : Repository {
    override fun loadTasks(): Flow<Task> {
        return flowOf(Task(1, "title", "description"))
    }
}