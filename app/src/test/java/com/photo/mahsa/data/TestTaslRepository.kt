package com.photo.mahsa.data

import com.photo.mahsa.model.Task
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOf

class TestTaskRepository: Repository {
    private val _userData = MutableSharedFlow<Task>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    override fun loadTasks(): Flow<Task> {
        return flowOf(Task(1, "test title", "test desc"))
    }
}