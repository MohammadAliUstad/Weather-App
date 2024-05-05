package com.seismic.weather.presentation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.seismic.weather.R
import com.seismic.weather.domain.weather.WeatherData
import java.time.format.DateTimeFormatter

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HourlyWeatherDisplay(
    weatherData: WeatherData,
    modifier: Modifier = Modifier
) {
    val customFontFamily = FontFamily(
        Font(R.font.product_sans_regular)
    )
    val formattedTime = remember(weatherData) {
        weatherData.time.format(
            DateTimeFormatter.ofPattern("HH:mm")
        )
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            modifier=Modifier.padding(start = 8.dp),
            text = formattedTime,
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = customFontFamily,
            )
        Image(
            painter = painterResource(id = weatherData.weatherType.iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp).padding(start = 8.dp)
        )
        Text(
            text = "${weatherData.temperatureCelsius}°C",
            color = MaterialTheme.colorScheme.onBackground,
            fontFamily = customFontFamily,
            fontWeight = FontWeight.Bold,
            modifier=Modifier.padding(start = 8.dp, bottom=10.dp)
        )
    }
}