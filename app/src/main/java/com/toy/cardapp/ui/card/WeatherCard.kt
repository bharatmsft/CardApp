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

@Preview
@Composable
internal fun WeatherCard(viewModel: WeatherViewModel = WeatherViewModel()) {
    val weatherState = viewModel.weather.collectAsState()
    val context = LocalContext.current
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = { makeToast(context, "weather card clicked") }
    ) {
        Text(text = "forecast: ${weatherState.value.forecast}")
        Text(text = "humidity: ${weatherState.value.humidity}")
    }
}