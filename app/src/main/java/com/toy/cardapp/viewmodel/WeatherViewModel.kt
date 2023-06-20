package com.toy.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.cardapp.model.Weather
import com.toy.cardapp.repository.fake.FakeWeatherRepository
import com.toy.cardapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class WeatherViewModel(private val repository: IWeatherRepository = FakeWeatherRepository()): ViewModel() {
    val weather: StateFlow<Weather> = repository.weather

    init {
        viewModelScope.launch {
            repository.fetchWeather()
        }
    }
}