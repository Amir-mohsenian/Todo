package com.photo.mahsa.ui.home

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun HomeRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY)
) {
    val pagingPhotoItems = viewModel.photoPages.collectAsLazyPagingItems()


    HomeScreen(pagingPhotoItems)
}


