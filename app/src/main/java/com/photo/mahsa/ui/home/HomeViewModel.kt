package com.photo.mahsa.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.paging.PagingData
import com.photo.mahsa.App
import com.photo.mahsa.data.Repository
import com.photo.mahsa.model.Photo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val repository: Repository
): ViewModel() {

    val photoPages = repository.loadPhotos(3)
    companion object {
        val FACTORY: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository = (this[APPLICATION_KEY] as App).appContainer.repository
                HomeViewModel(repository)
            }
        }
    }
}

data class UiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val photos: List<Photo> = emptyList()
)