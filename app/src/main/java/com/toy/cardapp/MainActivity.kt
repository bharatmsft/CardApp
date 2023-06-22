package com.toy.cardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.toy.cardapp.repository.fake.FakeCentralCardRepository
import com.toy.cardapp.repository.fake.FakeNewsRepository
import com.toy.cardapp.repository.fake.FakeTimeRepository
import com.toy.cardapp.repository.fake.FakeWeatherRepository
import com.toy.cardapp.ui.card.CentralCard
import com.toy.cardapp.ui.card.NewsCard
import com.toy.cardapp.ui.card.TimeCard
import com.toy.cardapp.ui.card.WeatherCard
import com.toy.cardapp.viewmodel.CentralCardViewModel
import com.toy.cardapp.viewmodel.NewsViewModel
import com.toy.cardapp.viewmodel.TimeViewModel
import com.toy.cardapp.viewmodel.WeatherViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val newsRepository = FakeNewsRepository()
        val timeRepository = FakeTimeRepository()
        val weatherRepository = FakeWeatherRepository()
        val centralCardRepository = FakeCentralCardRepository(
            newsRepository = newsRepository,
            timeRepository = timeRepository,
            weatherRepository = weatherRepository
        )
        setContent {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                // get this as an ordered list
                item { Box(modifier = Modifier.height(150.dp)) { CentralCard(CentralCardViewModel(centralCardRepository)) } }
                item { Box(modifier = Modifier.height(150.dp)) { NewsCard(NewsViewModel(newsRepository)) } }
                item { Box(modifier = Modifier.height(150.dp)) { WeatherCard(WeatherViewModel(weatherRepository)) } }
                item { Box(modifier = Modifier.height(150.dp)) { TimeCard(TimeViewModel(timeRepository)) } }
            }
        }
    }
}