package com.toy.cardapp.repository.interfaces

import com.toy.cardapp.model.Feature
import kotlinx.coroutines.flow.StateFlow

internal interface IFeaturesRepository {
    val features: StateFlow<List<Feature>>
    suspend fun fetchAvailableFeatures(): List<Feature>
    suspend fun rearrangeFeatures(predicate: (List<Feature>) -> List<Feature>): List<Feature>
}