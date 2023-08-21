package com.photo.mahsa.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.photo.mahsa.model.Photo
import com.photo.mahsa.model.PreviewPagingDataFlow
import com.photo.mahsa.ui.theme.MahsaTheme
import kotlinx.coroutines.flow.collect

@Composable
fun HomeScreen(
    pagingPhotos: LazyPagingItems<Photo>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {

            if (pagingPhotos.loadState.refresh == LoadState.Loading) {
                item {
                    Text(text = "Refresh Loading")
                }
            }

            items(count = pagingPhotos.itemCount) {
                val item = pagingPhotos[it]
                
                Text(text = item?.url ?: "null")
            }

            if (pagingPhotos.loadState.append == LoadState.Loading) {
                item {
                    Text(text = "New Items is adding")
                }
            }
        }

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    MahsaTheme {
        val previewItems = PreviewPagingDataFlow.collectAsLazyPagingItems()
        HomeScreen(previewItems)
    }
}


