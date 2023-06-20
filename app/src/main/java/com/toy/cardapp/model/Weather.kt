package com.toy.cardapp.model

import com.toy.cardapp.enums.ForecastType

internal data class Weather(
    val humidity: Int,
    val forecast: ForecastType
)