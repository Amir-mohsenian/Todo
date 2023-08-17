package com.photo.mahsa.ui.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.photo.mahsa.model.Photo
import com.photo.mahsa.ui.theme.MahsaTheme

@Composable
fun HomeScreen(
    photos: List<Photo>
) {

}

@Preview
@Composable
fun HomeScreenPreview() {
    MahsaTheme {
        HomeScreen(emptyList())
    }
}


