package com.example.panacea.domain.models.patient

import kotlinx.serialization.Serializable

@Serializable
data class Patient(
    val allergies: String,
    val birthDate: String,
    val caregiver: String,
    val diagnosis: String?,
    val direction: String,
    val email: String,
    val hygiene: String,
    val id: Int,
    val language: String,
    val medicalHistory: String,
    val mobilization: String?,
    val name: String,
    val password: String,
    val room: String?,
    val surname: String
)