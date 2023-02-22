package com.vinicius.mypurchaseorders.navigation

sealed class AppScreen (val route: String){
    object SplashActivity: AppScreen("SplashActivity")
    object Login: AppScreen("Login")
}