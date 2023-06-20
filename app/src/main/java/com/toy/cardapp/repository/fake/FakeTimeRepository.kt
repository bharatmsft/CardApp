package com.toy.cardapp.repository.fake

import com.toy.cardapp.model.Time
import com.toy.cardapp.repository.interfaces.ITimeRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class FakeTimeRepository: ITimeRepository {
    private val _time = MutableStateFlow(Time(0))
    override val time: StateFlow<Time> = _time

    override suspend fun fetchTime() {
        while (true) {
            _time.value = Time(System.currentTimeMillis())
            delay(1000)
        }
    }
}