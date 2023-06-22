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
import com.toy.cardapp.viewmodel.CentralCardViewModel

@Composable
internal fun CentralCard(viewModel: CentralCardViewModel) {
    val news = viewModel.news.collectAsState()
    val weather = viewModel.weather.collectAsState()
    val time = viewModel.timeInMillis.collectAsState()
    val context = LocalContext.current
    CentralCard(
        newsTitle = news.value.title,
        timeInMillis = time.value.timeInMillis,
        humidity = weather.value.humidity,
        onClick = { makeToast(context, "central card clicked") }
    )
}

@Preview
@Composable
fun CentralCard(
    newsTitle: String = "",
    timeInMillis: Long = 0L,
    humidity: Int = 0,
    onClick: () -> Unit = {}
) {
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = onClick
    ) {
        Text("title: $newsTitle")
        Text("time in ms: $timeInMillis")
        Text("humidity: $humidity")
    }
}