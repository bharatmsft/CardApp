package com.toy.cardapp.repository.interfaces

import com.toy.cardapp.model.News
import kotlinx.coroutines.flow.StateFlow

internal interface INewsRepository {
    val news: StateFlow<News>
    suspend fun fetchNews()
}