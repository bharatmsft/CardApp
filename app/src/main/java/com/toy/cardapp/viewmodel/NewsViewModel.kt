package com.toy.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.cardapp.model.News
import com.toy.cardapp.repository.fake.FakeNewsRepository
import com.toy.cardapp.repository.interfaces.INewsRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

internal class NewsViewModel(private val repository: INewsRepository = FakeNewsRepository()): ViewModel() {
    val news: StateFlow<News> = repository.news

    init {
        viewModelScope.launch {
            repository.fetchNews()
        }
    }
}