package com.toy.cardapp.ui.card

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.toy.cardapp.viewmodel.NewsViewModel

@Composable
internal fun NewsCard(
    viewModel: NewsViewModel
) {
    val state = viewModel.news.collectAsState()
    val context = LocalContext.current
    NewsCard(
        newsTitle = state.value.title,
        newsDate = state.value.date,
        newsAuthor = state.value.author,
        context = context
    )
}

@Preview
@Composable
internal fun NewsCard(
    newsTitle: String = "",
    newsDate: String = "",
    newsAuthor: String = "",
    context: Context = LocalContext.current
) {
    GlobalCard(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        onClick = { makeToast(context, "news card clicked") }
    ) {
        Text("title: $newsTitle")
        Text("date: $newsDate")
        Text("author: $newsAuthor")
    }
}