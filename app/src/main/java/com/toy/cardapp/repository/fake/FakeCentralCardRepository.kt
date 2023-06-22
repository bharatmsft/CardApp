package com.toy.cardapp.repository.fake

import com.toy.cardapp.model.CentralState
import com.toy.cardapp.repository.interfaces.ICentralCardRepository
import com.toy.cardapp.repository.interfaces.INewsRepository
import com.toy.cardapp.repository.interfaces.ITimeRepository
import com.toy.cardapp.repository.interfaces.IWeatherRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn

internal class FakeCentralCardRepository(
    private val newsRepository: INewsRepository,
    private val timeRepository: ITimeRepository,
    private val weatherRepository: IWeatherRepository
): ICentralCardRepository {
    private var _centralState: StateFlow<CentralState> = MutableStateFlow(CentralState())
    override val centralState: StateFlow<CentralState> = _centralState

    override suspend fun updateCentralState(
        scope: CoroutineScope,
        sharingMode: SharingStarted,
        default: CentralState
    ) {
        _centralState = combine(newsRepository.news, timeRepository.time, weatherRepository.weather) { news, time, weather ->
            CentralState(
                newsTitle = news.title,
                time = time.timeInMillis,
                humidity = weather.humidity
            )
        }.stateIn(scope, sharingMode, default)
    }
}