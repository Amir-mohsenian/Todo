package com.photo.mahsa.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.component.MutableTaskCard

@Composable
fun AddEditTaskScreen(
    task: Task?,
    onUpdateTask: (Task) -> Unit
) {
    var mutableTask by remember {
        mutableStateOf(task ?: Task(title = "", desc = ""))
    }
    Column(modifier = Modifier.fillMaxSize()) {
        MutableTaskCard(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            task = mutableTask,
            onDoneAction = {
                onUpdateTask(mutableTask)
            },
            onTaskChanged = {
                mutableTask = it
            })

        Button(
            onClick = {
                onUpdateTask(mutableTask) },
            modifier = Modifier
                .padding(bottom = 24.dp, start = 20.dp, end = 20.dp)
                .height(64.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Update Task")
        }
    }
}