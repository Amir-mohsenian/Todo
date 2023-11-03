package com.photo.mahsa.ui.detail

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.home.HomeViewModel

@Composable
fun AddEditTaskRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY),
    selectedTask: Task?,
    onBackAction: () -> Unit) {
    AddEditTaskScreen(task = selectedTask, onUpdateTask = {
        viewModel.updateTask(it)
        onBackAction()
    })
}