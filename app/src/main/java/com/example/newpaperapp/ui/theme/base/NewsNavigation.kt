package com.example.newpaperapp.ui.theme.base

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.studentcomposeapp.ui.Screen.NewsList
import com.example.studentcomposeapp.ui.Screen.SplashScreen


@Composable
fun NewsNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("newslist") { NewsList(navController) }
    }
}