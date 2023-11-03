package com.photo.mahsa.data

import com.photo.mahsa.model.Task
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flowOf

class TestTaskRepository : Repository {
    private val _userData =
        MutableSharedFlow<List<Task>>(replay = 1, onBufferOverflow = BufferOverflow.DROP_OLDEST)

    private val _data = mutableListOf<Task>()
    override fun loadTasks(): Flow<List<Task>> {
        return _userData
    }

    override suspend fun addTask(task: Task): Boolean {
       _data.add(task)
       emitData()
        return true
    }

    override suspend fun removeTask(task: Task): Boolean {
        _data.remove(task)
        emitData()
        return true
    }

    override suspend fun updateTask(task: Task) {
        TODO("Not yet implemented")
    }

    private fun emitData() {_userData.tryEmit(_data)}
}