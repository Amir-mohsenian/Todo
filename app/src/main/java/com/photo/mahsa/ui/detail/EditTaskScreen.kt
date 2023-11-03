package com.photo.mahsa.ui.detail

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.component.MutableTaskCard

@Composable
fun EditTaskScreen(
    task: Task,
    onUpdateTask: (Task) -> Unit
) {
    var mutableTask by remember {
        mutableStateOf(task)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        MutableTaskCard(
            modifier = Modifier.fillMaxWidth().weight(1f),
            task = mutableTask,
            onTaskChanged = {
            mutableTask = it
        })

        Button(onClick = { onUpdateTask(mutableTask) }) {
            Text(text = "Update Task")
        }
    }
}