package com.photo.mahsa.ui.component

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.photo.mahsa.model.Task

@Composable
fun MutableTaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onDoneAction: () -> Unit,
    onTaskChanged: (Task) -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        TextField(
            modifier = Modifier
                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
                .testTag("editable_title_test")
                .animateContentSize(),
            value = task.title,
            placeholder = {
                Text(text = "Title")
            },
            onValueChange = {
                onTaskChanged(task.copy(title = it))
            })

        TextField(
            modifier = Modifier
                .padding(top = 8.dp, start = 24.dp, end = 24.dp)
                .fillMaxWidth()
                .testTag("editable_desc_test")
                .animateContentSize(),
            value = task.desc,
            placeholder = {
                Text(text = "Description")
            },
            keyboardActions = KeyboardActions(onDone = {onDoneAction()}),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            onValueChange = {
                onTaskChanged(task.copy(desc = it))
            })
    }
}