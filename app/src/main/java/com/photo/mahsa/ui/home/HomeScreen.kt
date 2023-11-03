package com.photo.mahsa.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.component.ImmutableTaskCard
import com.photo.mahsa.ui.theme.AppTheme

@Composable
fun HomeScreen(
    uiState: UiState,
    onSelectedTask: (Task) -> Unit
) {
    val listState = rememberLazyListState()
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        when (uiState) {
            is UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.size(58.dp))
            }

            is UiState.Error -> {
                Text(text = "Error is ${uiState.message}")
            }

            is UiState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    state = listState,
                    contentPadding = PaddingValues(top = 8.dp, bottom = 48.dp, start = 8.dp, end = 8.dp),
                ) {
                    items(uiState.tasks, key = { key -> key.id!!}) { task ->
                        ImmutableTaskCard(modifier = Modifier.padding(top = 10.dp).padding(horizontal = 4.dp),task = task, onClick = onSelectedTask)
                    }
                }
            }
        }
    }
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
    AppTheme {
    }
}


