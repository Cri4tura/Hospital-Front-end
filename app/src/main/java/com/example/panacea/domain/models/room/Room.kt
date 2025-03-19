package com.example.panacea.domain.models.room

import com.example.panacea.domain.models.patient.Patient
import kotlinx.serialization.Serializable

@Serializable
data class Room(
    val id: Int,
    val name: String,
    val patient: Patient?,
    val section: String
)