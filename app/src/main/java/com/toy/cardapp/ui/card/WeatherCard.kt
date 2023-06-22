package com.toy.cardapp.ui.card

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toy.cardapp.viewmodel.WeatherViewModel

@Composable
internal fun WeatherCard(viewModel: WeatherViewModel) {
    val weatherState = viewModel.weather.collectAsState()
    val context = LocalContext.current
    WeatherCard(
        forecast = weatherState.value.forecast.name,
        humidity = weatherState.value.humidity,
        onClick = { makeToast(context, "weather card clicked") }
    )
}

@Preview
@Composable
internal fun WeatherCard(
    forecast: String = "",
    humidity: Int = 0,
    onClick: () -> Unit = {}
) {
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = onClick
    ) {
        Text(text = "forecast: $forecast")
        Text(text = "humidity: $humidity")
    }
}