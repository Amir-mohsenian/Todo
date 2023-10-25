package com.photo.mahsa.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY)
) {

  //  val uiState by viewModel.uiState.collectAsState()

   // HomeScreen(uiState)
}


