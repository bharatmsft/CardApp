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
import com.toy.cardapp.ui.card.NewsCard
import com.toy.cardapp.ui.card.TimeCard
import com.toy.cardapp.ui.card.WeatherCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                // get this as an ordered list
                item { Box(modifier = Modifier.height(150.dp)) { NewsCard() } }
                item { Box(modifier = Modifier.height(150.dp)) { WeatherCard() } }
                item { Box(modifier = Modifier.height(150.dp)) { TimeCard() } }
            }
        }
    }
}