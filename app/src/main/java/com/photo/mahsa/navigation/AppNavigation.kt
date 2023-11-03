package com.photo.mahsa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.photo.mahsa.ui.detail.AddEditTaskRoute
import com.photo.mahsa.ui.home.HomeRoute

const val HOME_ROUTE = "home_route"
const val DETAIL_ROUTE = "detail_route"
@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier,
    startDest: String = HOME_ROUTE,
) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDest
    ) {
        composable(
            route = HOME_ROUTE
        ) {
            HomeRoute()
        }

        composable(
            route = DETAIL_ROUTE
        ) {
            AddEditTaskRoute(selectedTask = null) {
                navController.navigateUp()
            }
        }
    }
}

