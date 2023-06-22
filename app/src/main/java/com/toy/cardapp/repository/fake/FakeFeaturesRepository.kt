package com.toy.cardapp.repository.fake

import com.toy.cardapp.enums.FeaturesType
import com.toy.cardapp.model.Feature
import com.toy.cardapp.repository.interfaces.IFeaturesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlin.random.Random

class FakeFeaturesRepository : IFeaturesRepository {
    private val _features = MutableStateFlow(listOf<Feature>())
    override val features: StateFlow<List<Feature>> = _features

    override suspend fun fetchAvailableFeatures(): List<Feature> {
        val list = listOf(
            Feature(FeaturesType.NEWS.name, true, 3),
            Feature(FeaturesType.TIME.name, true, 7),
            Feature(FeaturesType.WEATHER.name, true, 0),
            Feature(FeaturesType.TODO.name, false, 14)
        )
        _features.value = rearrangeFeatures { rearrangeByOrder(list) }
        return features.value
    }

    override suspend fun rearrangeFeatures(predicate: (List<Feature>) -> List<Feature>): List<Feature> {
        _features.value = predicate(features.value)
        return features.value
    }

    private fun rearrangeByOrder(features: List<Feature>): List<Feature> {
        return features.filter { it.isEnabled }.sortedBy { it.order }
    }
}