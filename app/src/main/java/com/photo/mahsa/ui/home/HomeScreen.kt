package com.photo.mahsa.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.photo.mahsa.model.Photo
import com.photo.mahsa.model.PreviewPagingDataFlow
import com.photo.mahsa.ui.theme.MahsaTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HomeScreen(
    pagingPhotos: LazyPagingItems<Photo>
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
        ) {

            if (pagingPhotos.loadState.refresh == LoadState.Loading) {
                item {
                    LinearProgressIndicator(color = Color.Blue, modifier = Modifier.fillMaxWidth())
                }
            }

            items(count = pagingPhotos.itemCount) {
                val item = pagingPhotos[it]
                GlideImage(
                    model = {
                        item?.url
                    },
                    contentDescription = null,
                    modifier = Modifier
                        .height(if (it % 2 == 0) 150.dp else 200.dp)
                        .padding(horizontal = 2.dp, vertical = 4.dp),
                    contentScale = ContentScale.Crop
                )
            }

            if (pagingPhotos.loadState.append == LoadState.Loading) {
                item {
                   // Text(text = "New Items is adding")
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


