package com.toy.cardapp.repository.fake

import com.toy.cardapp.model.News
import com.toy.cardapp.repository.interfaces.INewsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

internal class FakeNewsRepository: INewsRepository {
    private var tmpNews: News = News()
    private val _news = MutableStateFlow(tmpNews)

    override val news: StateFlow<News> = _news

    override suspend fun fetchNews() {
        while (true) {
            val rand = UUID.randomUUID().toString().substring(0, 8)
                tmpNews = News(
                    title = rand,
                    shortDescription = rand,
                    longDescription = rand,
                    date = rand,
                    author = rand
                )
            _news.value = tmpNews
            delay(1000 * 5)
        }
    }
}