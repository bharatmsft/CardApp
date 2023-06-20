package com.toy.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.cardapp.model.Time
import com.toy.cardapp.repository.fake.FakeTimeRepository
import com.toy.cardapp.repository.interfaces.ITimeRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TimeViewModel(private val repository: ITimeRepository = FakeTimeRepository()): ViewModel() {
    val time: StateFlow<Time> = repository.time

    init {
        viewModelScope.launch {
            repository.fetchTime()
        }
    }
}