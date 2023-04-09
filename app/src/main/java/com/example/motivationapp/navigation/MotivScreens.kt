package com.example.motivationapp.navigation

enum class MotivScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
    HomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStateScreen;

    /*

    companion object{
        fun fromRoute(route : String): MotivScreens
        = when(route?.substringBefore("/")){
            SplashScreen.name ->SplashScreen
            LoginScreen.name->LoginScreen
            CreateAccountScreen.name->CreateAccountScreen
            HomeScreen.name->HomeScreen
            SearchScreen.name->SearchScreen
            DetailScreen.name->DetailScreen
            UpdateScreen.name->UpdateScreen
            ReaderStateScreen.name->ReaderStateScreen
            null ->ReaderStateScreen
            else ->throw IllegalArgumentException("Route $route is not recognise ")
        }
    }

     */





}