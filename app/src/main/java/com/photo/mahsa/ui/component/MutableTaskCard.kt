package com.photo.mahsa.ui.component

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import com.photo.mahsa.model.Task

@Composable
fun MutableTaskCard(
    modifier: Modifier = Modifier,
    task: Task,
    onTaskChanged: (Task) -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        TextField(
            modifier = Modifier.testTag("editable_title_test").animateContentSize(),
            value = task.title,
            onValueChange = {
                Log.i("****LOOOG", "it is ${it}")
           onTaskChanged(task.copy(title = it))
        })

        TextField(
            modifier = Modifier.testTag("editable_desc_test").animateContentSize(),
            value = task.desc,
            onValueChange = {
            onTaskChanged(task.copy(desc = it))
        })
    }
}