package com.photo.mahsa.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.photo.mahsa.ui.theme.MahsaTheme

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY)
) {
    val pagingPhotoItems = viewModel.photoPages.collectA
    HomeScreen()
}


