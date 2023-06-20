package com.toy.cardapp.repository.fake

import com.toy.cardapp.enums.ForecastType
import com.toy.cardapp.model.Weather
import com.toy.cardapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

internal class FakeWeatherRepository: IWeatherRepository {
    private val _weather: MutableStateFlow<Weather> = MutableStateFlow(Weather(humidity = 50, forecast = ForecastType.SUNNY))
    override val weather: StateFlow<Weather> = _weather

    override suspend fun fetchWeather() {
        while(true) {
            _weather.value = Weather(humidity = Random.nextInt(from = 0, until = 100), forecast = ForecastType.values().random())
            delay(1000 * 5)
        }
    }
}