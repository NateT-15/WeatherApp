package com.example.weatherapp.screens

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CurrentWeatherScreen(onForecastClick: () -> Unit) {
    //placeholder data, these values will come from weather API later
    val city = "Halifax"
    val temperature = "18°C"
    val condition = "Partly Cloudy"
    val feelsLike = "17°C"
    val humidity = "68%"
    val windSpeed = "14 km/h"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF4FF))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        //Location
        Row(
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = city,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))

        //Main weather information
        Text(
            text = "☀\uFE0F",
            fontSize = 80.sp
        )

        Text(
            text= temperature,
            fontSize = 64.sp,
            fontWeight = FontWeight.Light
        )

        Text(
            text = condition,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium
        )

        Text(
            text = feelsLike,
            fontSize = 16.sp,
            color = Color.Gray
        )

        Spacer(modifier = Modifier.height(40.dp))

        //additional weather information
        Card(
            modifier = Modifier.fillMaxWidth()
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                WeatherDetail(
                    title = "wind",
                    value = windSpeed
                )
            }
        }
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {
                onForecastClick()
            },
            modifier = Modifier.fillMaxWidth()
        ){
            Text("View Daily Forecast")
        }
    }
}

@Composable
private fun WeatherDetail(
    title: String,
    value: String,
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = value,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = title,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}