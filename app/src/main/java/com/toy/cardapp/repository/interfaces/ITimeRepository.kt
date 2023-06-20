package com.toy.cardapp.repository.interfaces

import com.toy.cardapp.model.Time
import kotlinx.coroutines.flow.StateFlow

interface ITimeRepository {
    val time: StateFlow<Time>
    suspend fun fetchTime()
}