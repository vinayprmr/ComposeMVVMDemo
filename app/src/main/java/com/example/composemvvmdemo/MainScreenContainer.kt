package com.example.composemvvmdemo

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composemvvmdemo.screens.HomeScreen
import com.example.composemvvmdemo.screens.login.LogInScreen
import com.example.composemvvmdemo.screens.signup.SignUpScreen
import com.example.composemvvmdemo.screens.splash.SplashScreen
import com.example.composemvvmdemo.utils.Routes

@Composable
fun MainScreenContainer() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.Splash.route) {
        composable(Routes.Splash.route) {
            SplashScreen(navController)
        }
        composable(Routes.LogIn.route) {
            LogInScreen(navController)
        }
        composable(Routes.SignUp.route) {
            SignUpScreen(navController)
        }
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
    }
}