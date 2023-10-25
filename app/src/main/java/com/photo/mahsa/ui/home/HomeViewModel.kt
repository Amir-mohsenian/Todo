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
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: Repository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Error(""))
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {

           // _uiState.value = UiState.Success(data = data)
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