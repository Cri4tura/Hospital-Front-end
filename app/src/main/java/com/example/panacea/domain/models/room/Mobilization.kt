package com.example.panacea.domain.models.room

import kotlinx.serialization.Serializable

@Serializable
data class Mobilization(
    val id: Int,
    val posturalChange: Boolean,
    val sittingType: String,
    val wandering: Boolean,
    val wanderingType: String
)