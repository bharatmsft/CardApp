package com.toy.cardapp.repository.interfaces

import com.toy.cardapp.model.Weather
import kotlinx.coroutines.flow.StateFlow

internal interface IWeatherRepository {
    val weather: StateFlow<Weather>
    suspend fun fetchWeather()
}