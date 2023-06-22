package com.toy.cardapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.toy.cardapp.model.Feature
import com.toy.cardapp.repository.interfaces.IFeaturesRepository
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

internal class FeatureViewModel(
    private val featuresRepository: IFeaturesRepository
): ViewModel() {
    val features: StateFlow<List<Feature>> = featuresRepository.features

    init {
        viewModelScope.launch {
            featuresRepository.fetchAvailableFeatures()
            featuresRepository.rearrangeFeatures { featureList ->
                featureList.filter { it.isEnabled }.sortedByDescending { it.order }
            }
        }
    }
}