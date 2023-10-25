package com.photo.mahsa

import com.photo.mahsa.data.TestTaskRepository
import com.photo.mahsa.ui.home.HomeViewModel
import com.photo.mahsa.ui.home.UiState
import com.photo.mahsa.util.MainDispatcherRule
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

    }
}