package com.vinicius.mypurchaseorders.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vinicius.mypurchaseorders.views.Login
import com.vinicius.mypurchaseorders.views.Login
import com.vinicius.mypurchaseorders.views.Login
import com.vinicius.mypurchaseorders.views.Splash

@Composable
fun AppNavigation(){
    val navControler = rememberNavController()
    NavHost(
        navController = navControler ,
        startDestination = AppScreen.SplashActivity.route,
    ){
        composable(AppScreen.SplashActivity.route){
            Splash(navControler)
        }
        composable(AppScreen.Login.route){
            Login()
        }
    }
}