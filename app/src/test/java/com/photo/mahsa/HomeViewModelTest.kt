package com.photo.mahsa

import com.photo.mahsa.data.TestTaskRepository
import com.photo.mahsa.model.Task
import com.photo.mahsa.ui.home.HomeViewModel
import com.photo.mahsa.ui.home.UiState
import com.photo.mahsa.util.MainDispatcherRule
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.*

class HomeViewModelTest {
    @get:Rule
    val dispatcherRule = MainDispatcherRule()

    private val repository = TestTaskRepository()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        viewModel = HomeViewModel(repository)
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(UiState.Loading, viewModel.uiState.value)
    }

    @Test
    fun oneTask_showInHome() = runTest {
        val collectJob = launch(UnconfinedTestDispatcher()) { viewModel.uiState.collect() }
        viewModel.addTask(Task(id = 1, title = "title", desc = "desc"))
        assertIs<UiState.Success>(viewModel.uiState.value)
        assertEquals(1, (viewModel.uiState.value as UiState.Success).tasks.size)
        collectJob.cancel()
    }
}