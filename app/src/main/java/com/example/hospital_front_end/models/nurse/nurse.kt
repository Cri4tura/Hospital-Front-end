package com.example.hospital_front_end.models.nurse

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.ZoneId
import java.util.Date


data class Nurse(
    val id: Int,
    val name: String,
    val surname: String,
    val email: String,
    val registerDate: Date,
    val birthDate: Date
) {
    val age: Int
        get() {
            val today = LocalDate.now()
            val birthLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
            return Period.between(birthLocalDate, today).years
        }

    fun formatDate(date: Date): String {
        return SimpleDateFormat("dd/MM/yyyy").format(date)
    }
}






