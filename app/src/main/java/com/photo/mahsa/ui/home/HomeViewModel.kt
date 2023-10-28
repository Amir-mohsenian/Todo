package com.photo.mahsa.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.photo.mahsa.App
import com.photo.mahsa.data.Repository
import com.photo.mahsa.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    val uiState: StateFlow<UiState> = repository.loadTasks()
        .map { UiState.Success(it) }
        .onStart { UiState.Loading }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), UiState.Loading)

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