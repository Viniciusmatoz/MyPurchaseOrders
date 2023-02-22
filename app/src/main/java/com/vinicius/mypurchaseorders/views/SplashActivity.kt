package com.vinicius.mypurchaseorders.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.vinicius.mypurchaseorders.R
import com.vinicius.mypurchaseorders.navigation.AppScreen
import com.vinicius.mypurchaseorders.ui.theme.DarkBlackground
import com.vinicius.mypurchaseorders.ui.theme.YellowDefault
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavController){
    LaunchedEffect(key1 = true ){
        delay(3000)
        navController.popBackStack()
        navController.navigate(AppScreen.Login.route)
    }
    SplashScrenn()
}

@Composable
fun SplashScrenn(){
    Column(
        modifier = Modifier.fillMaxSize().background(DarkBlackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = painterResource(id = R.drawable.splash_screen), contentDescription = null )
        Text(
            text = "Solicitações de Compra",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = YellowDefault
        )
    }
}
@Preview
@Composable
fun Mostrar(){
    SplashScrenn()
}