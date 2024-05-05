package com.seismic.weather.domain.repository

import com.seismic.weather.domain.util.Resource
import com.seismic.weather.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}