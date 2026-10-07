package com.example.weatherapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.overscroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ForecastDay(
    val day: String,
    val icon: String,
    val condition: String,
    val highTemp: String,
    val lowTemp: String
)

@Composable
fun ForecastScreen(onBackClick: () -> Unit) {

    val forecastData = listOf(
        ForecastDay("Monday", "☀\uFE0F", "Sunny", "21°C", "13°C"),
        ForecastDay("Tuesday", "\uD83C\uDF27\uFE0F", "Rain", "17°C", "10°C"),
        ForecastDay("Wednesday", "☁\uFE0F", "Cloudy", "18°C", "11°C"),
        ForecastDay("Thursday", "\uD83C\uDF25\uFE0F", "Partly Cloudy", "20°C", "12°C"),
        ForecastDay("Friday", "⛈\uFE0F", "Thunderstorms", "16°C", "8°C"),
        ForecastDay("Saturday", "☀\uFE0F", "Sunny", "22°C", "14°C"),
        ForecastDay("Sunday", "\uD83C\uDF26\uFE0F", "Showers", "19°C", "11°C")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFEAF4FF))
            .padding(16.dp)
    ){
      Text(
          text = "7 Day Forecast",
          fontSize = 30.sp,
          fontWeight = FontWeight.Bold
      )

        Button(onClick = onBackClick){
            Text("Back")
        }
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Halifax, NS",
            fontSize = 18.sp,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ){
            items(forecastData) { day ->

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                        )
                    ){

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ){

                        Text(
                            text = day.icon,
                            fontSize = 32.sp
                        )
                        Spacer(modifier = Modifier.width(16.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ){

                            Text(
                                text = day.day,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = day.condition,
                                color = Color.Gray
                            )
                        }

                        Column(
                            horizontalAlignment = Alignment.End
                        ){
                            Text(
                                text = day.highTemp,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp
                            )

                            Text(text = day.lowTemp,
                                color = Color.Gray
                            )
                        }
                    }
                }
            }
        }
    }
}