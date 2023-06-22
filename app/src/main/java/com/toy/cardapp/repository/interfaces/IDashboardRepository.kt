package com.toy.cardapp.repository.interfaces

import androidx.core.graphics.BitmapCompat

interface IDashboardRepository {
    suspend fun getProfilePicture(): BitmapCompat
}