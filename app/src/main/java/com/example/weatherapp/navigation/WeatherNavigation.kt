package com.example.weatherapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.weatherapp.screens.CurrentWeatherScreen
import com.example.weatherapp.screens.ForecastScreen

@Composable
fun WeatherNavigation() {

    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "current_weather"
    ) {
        composable("current_weather") {
            CurrentWeatherScreen(
                onForecastClick = {
                    navController.navigate("forecast")
                }
            )
        }
        composable("forecast") {
            ForecastScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
