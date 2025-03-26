package com.example.panacea.domain.models.patient

import com.example.panacea.domain.models.room.Diagnosis
import com.example.panacea.domain.models.room.Mobilization
import kotlinx.serialization.Serializable

@Serializable

data class Patient(
    val allergies: String,
    val birthDate: String,
    val caregiver: String,
    val diagnosis: Diagnosis?,
    val direction: String,
    val email: String,
    val hygiene: String,
    val id: Int,
    val language: String,
    val medicalHistory: String,
    val mobilization: Mobilization?,
    val name: String,
    val password: String,
    //val room: String?,
    val surname: String
)