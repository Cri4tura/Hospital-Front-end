package com.example.panacea.domain.models.room

import kotlinx.serialization.Serializable

@Serializable
data class Diagnosis(
    val dependence: String,
    val diaper: Boolean,
    val id: Int,
    val numberOfChronicDiseases: Int,
    val o2: String
)