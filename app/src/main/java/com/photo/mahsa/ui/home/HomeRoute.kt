package com.photo.mahsa.ui.home

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY),
    snackbarHostState: SnackbarHostState
) {

    val uiState by viewModel.uiState.collectAsState()

    HomeScreen(uiState) {

    }
}


