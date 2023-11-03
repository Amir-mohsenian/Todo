package com.photo.mahsa.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.photo.mahsa.App
import com.photo.mahsa.data.Repository
import com.photo.mahsa.model.Task
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import com.photo.mahsa.ui.home.UiState.*
import kotlinx.coroutines.flow.onEach

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    val uiState: StateFlow<UiState> = repository.loadTasks()
        .map {Success(it)}
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            Loading
        )

    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.addTask(task)
        }
    }

    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task)
        }
    }

    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as App).appContainer.repository
                HomeViewModel(repository)
            }
        }
    }
}

sealed interface UiState {
    object Loading : UiState
    data class Error(val message: String) : UiState

    data class Success(
        val tasks: List<Task> = emptyList()
    ) : UiState
}