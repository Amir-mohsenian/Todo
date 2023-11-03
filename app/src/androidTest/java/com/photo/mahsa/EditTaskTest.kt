package com.photo.mahsa

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import com.photo.mahsa.ui.detail.EditTaskRoute
import com.photo.mahsa.ui.home.HomeViewModel
import com.photo.mahsa.ui.theme.MahsaTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test

class EditTaskTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val testRepository = TestTaskRepository()
    @Test
    fun changeTaskTitle() {
        composeTestRule.setContent {
            MahsaTheme {
                EditTaskRoute(selectedTask = TestModel.fakeTaskList.first(), viewModel = HomeViewModel(testRepository))
            }
        }

        val testTitle = "This is the first test title"
        val testDesc = "this is desc"
        composeTestRule.onNodeWithTag("editable_title_test").assertTextEquals(TestModel.fakeTaskList.first().title)
        composeTestRule.onNodeWithTag("editable_title_test").performTextClearance()
        composeTestRule.onNodeWithTag("editable_desc_test").performTextClearance()
        composeTestRule.onNodeWithTag("editable_title_test").performTextInput(testTitle)
        composeTestRule.onNodeWithTag("editable_desc_test").performTextInput(testDesc)
        composeTestRule.onNodeWithText("Update Task").performClick()
        //it is a delay for developers who enjoy watching automated test
        runBlocking {
            delay(2000)
        }
        composeTestRule.onNodeWithText(testTitle).assertIsDisplayed()
        composeTestRule.onNodeWithText(testDesc).assertIsDisplayed()

    }
}