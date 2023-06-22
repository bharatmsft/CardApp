package com.toy.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.cardapp.model.CentralState
import com.toy.cardapp.repository.fake.FakeCentralCardRepository
import com.toy.cardapp.repository.fake.FakeNewsRepository
import com.toy.cardapp.repository.fake.FakeTimeRepository
import com.toy.cardapp.repository.fake.FakeWeatherRepository
import com.toy.cardapp.repository.interfaces.ICentralCardRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class CentralCardViewModel(
    private val centralCardRepository: ICentralCardRepository = FakeCentralCardRepository(
        newsRepository = FakeNewsRepository(),
        timeRepository = FakeTimeRepository(),
        weatherRepository = FakeWeatherRepository()
    )
): ViewModel() {
    val centralState: StateFlow<CentralState> = centralCardRepository.centralState

    init {
        viewModelScope.launch {
            centralCardRepository.updateCentralState(viewModelScope, sharingMode = SharingStarted.Eagerly, default = CentralState())
        }
    }
}
