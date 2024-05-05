package com.seismic.weather.presentation

import android.os.Build
import com.seismic.weather.R
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherCard(
    state: WeatherState,
    modifier: Modifier = Modifier
) {
    val customFontFamily = FontFamily(
        Font(R.font.product_sans_regular)
    )
    state.weatherInfo?.currentWeatherData?.let { data ->
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = modifier.padding(start=8.dp, end=8.dp, bottom = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor= MaterialTheme.colorScheme.primaryContainer
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 1.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Today ${
                        data.time.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        )
                    }",
                    fontFamily = customFontFamily,
                    modifier = Modifier.align(Alignment.Start),
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(16.dp))
                Image(
                    painter = painterResource(id = data.weatherType.iconRes),
                    contentDescription = null,
                    modifier = Modifier.width(200.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    fontFamily = customFontFamily,
                    text = "${data.temperatureCelsius}°C",
                    fontSize = 50.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    fontFamily = customFontFamily,
                    text = data.weatherType.weatherDesc,
                    fontSize = 20.sp,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WeatherDataDisplay(
                        value = data.pressure.roundToInt(),
                        unit = " hpa",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_pressure)
                    )
                    WeatherDataDisplay(
                        value = data.humidity.roundToInt(),
                        unit = " %",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_drop)
                    )
                    WeatherDataDisplay(
                        value = data.windSpeed.roundToInt(),
                        unit = " km/h",
                        icon = ImageVector.vectorResource(id = R.drawable.ic_wind)
                    )
                }
            }
        }
    }
}