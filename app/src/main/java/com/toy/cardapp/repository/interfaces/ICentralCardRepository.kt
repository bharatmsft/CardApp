package com.toy.cardapp.repository.interfaces

import com.toy.cardapp.model.CentralState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow

interface ICentralCardRepository {
    val centralState: StateFlow<CentralState>
    suspend fun updateCentralState(
        scope: CoroutineScope,
       sharingMode: SharingStarted,
       default: CentralState
    )
}