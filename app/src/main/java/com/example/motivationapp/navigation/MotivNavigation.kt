package com.example.motivationapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.motivationapp.presentation.login.CreateAccountScreen
import com.example.motivationapp.presentation.login.LoginScreen
import com.example.motivationapp.presentation.screens.homeScreen.HomeScreen
import com.example.motivationapp.presentation.screens.splashScreen.SplashScreen





@Composable
fun MotivNavigation(){
  val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MotivScreens.SplashScreen.name ){
        composable(MotivScreens.SplashScreen.name){
            SplashScreen(navController)
        }
        composable(MotivScreens.HomeScreen.name){
            HomeScreen()
        }
        composable(MotivScreens.LoginScreen.name){
            LoginScreen(
                navController = navController
            )
        }
        composable(MotivScreens.CreateAccountScreen.name){
            CreateAccountScreen(navController = navController)
        }
    }
}