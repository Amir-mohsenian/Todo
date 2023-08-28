package com.photo.mahsa.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.photo.mahsa.ui.detail.DetailRoute
import com.photo.mahsa.ui.home.HomeRoute
import com.photo.mahsa.ui.home.HomeViewModel

const val HOME_ROUTE = "home_route"
const val DETAIL_ROUTE = "detail_route"
@Composable
fun PhotoNavHost(
    navController: NavHostController,
    modifier: Modifier,
    startDest: String = "home_route",
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
            DetailRoute()
        }
    }
}

