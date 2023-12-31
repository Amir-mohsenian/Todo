package com.photo.mahsa.ui.detail

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.home.HomeViewModel
import kotlinx.coroutines.launch

@Composable
fun AddEditTaskRoute(
    viewModel: HomeViewModel = viewModel(factory = HomeViewModel.FACTORY),
    selectedTask: Task?,
    snackbarHostState: SnackbarHostState,
    onBackAction: () -> Unit) {
    val scope = rememberCoroutineScope()
    AddEditTaskScreen(task = selectedTask, onUpdateTask = {
        if (it.title.isBlank() && it.desc.isBlank()) {
            scope.launch {
                snackbarHostState.showSnackbar("It can't be empty")
            }
        } else {
            viewModel.updateTask(it)
            onBackAction()
        }
    })
}