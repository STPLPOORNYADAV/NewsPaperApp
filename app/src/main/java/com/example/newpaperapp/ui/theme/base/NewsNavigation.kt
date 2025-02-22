package com.example.newpaperapp.ui.theme.base


import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newpaperapp.data.model.NewspaperItem
import com.example.newpaperapp.ui.theme.screen.NewspaperDetailScreen
import com.example.newpaperapp.ui.theme.screen.NewspaperListScreen
import com.example.newpaperapp.ui.theme.viewmodel.NewspaperListViewModel
import com.example.studentcomposeapp.ui.Screen.SplashScreen



import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.newpaperapp.ui.theme.screen.NewspaperDetailScreen
import com.example.newpaperapp.ui.theme.screen.NewspaperListScreen
import com.example.studentcomposeapp.ui.Screen.SplashScreen

@Composable
fun NewsNavigation(navController: NavHostController, viewModel: NewspaperListViewModel) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController)
        }
        composable("list") {
            NewspaperListScreen(navController, viewModel) { newspaper ->
                val encodedUrl = Uri.encode(newspaper.url)
                navController.navigate("detail/$encodedUrl")  // ✅ Only passing the URL
            }
        }
        composable(
            "detail/{url}",
            arguments = listOf(
                navArgument("url") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val url = backStackEntry.arguments?.getString("url") ?: ""
            NewspaperDetailScreen(url) // ✅ Correct parameter passed
        }
    }
}

