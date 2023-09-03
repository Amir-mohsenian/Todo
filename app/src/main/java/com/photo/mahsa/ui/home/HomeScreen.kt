package com.photo.mahsa.ui.home

import androidx.compose.animation.graphics.ExperimentalAnimationGraphicsApi
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.photo.mahsa.R
import com.photo.mahsa.model.Photo
import com.photo.mahsa.model.PreviewPagingDataFlow
import com.photo.mahsa.ui.theme.MahsaTheme
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(
    pagingPhotos: LazyPagingItems<Photo>
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        if (pagingPhotos.loadState.refresh == LoadState.Loading) {
            LinearProgressIndicator(color = Color.Blue, modifier = Modifier.fillMaxWidth())
        }

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier.weight(1f),
        ) {

            items(count = pagingPhotos.itemCount) {
                val item = pagingPhotos[it]
                item?.let {
                    ImageItem(photo = item, modifier = Modifier.padding(4.dp))
                }
            }
        }

        if (pagingPhotos.loadState.append == LoadState.Loading) {
            CircularProgressIndicator(modifier = Modifier
                .padding(bottom = 12.dp)
                .size(48.dp)
                .padding(vertical = 8.dp))
        }

    }
}

@Composable
fun ImageItem(
    modifier: Modifier = Modifier,
    photo: Photo,
) {
    Box(modifier = modifier) {
        GlideImage(
            imageModel = { photo.url },
            imageOptions = ImageOptions(
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 3.dp, vertical = 4.dp)
                .background(
                    color = Color(0x33FFFFFF),
                    shape = MaterialTheme.shapes.large
                )
                .fillMaxWidth()
                .height(40.dp)
                .padding(vertical = 2.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AnimatedFavouriteImage(onClick = {})
        }
    }
}

@OptIn(ExperimentalAnimationGraphicsApi::class)
@Composable
fun AnimatedFavouriteImage(
    onClick: (isFill: Boolean) -> Unit) {
    val image = AnimatedImageVector.animatedVectorResource(R.drawable.avd_heart_fill)
    var atEnd by remember { mutableStateOf(false) }
    Image(
        painter = rememberAnimatedVectorPainter(image, atEnd),
        contentDescription = null,
        modifier = Modifier.noRippleClickable {
            atEnd = !atEnd
            onClick(atEnd)
        },
        contentScale = ContentScale.Crop
    )
}

inline fun Modifier.noRippleClickable(
    crossinline onClick: () -> Unit
): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
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


