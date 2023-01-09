package com.example.composemvvmdemo.utils

sealed class Routes(val route: String) {
    object Splash : Routes("Splash")
    object LogIn : Routes("LogIn")
    object SignUp : Routes("SignUp")
    object Home : Routes("Home")
}