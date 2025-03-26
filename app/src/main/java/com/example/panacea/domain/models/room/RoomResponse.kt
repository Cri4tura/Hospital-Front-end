package com.example.panacea.domain.models.room

import kotlinx.serialization.Serializable

@Serializable
data class RoomResponse(
    val count: Int,
    val `data`: List<Room>,
    val status: String
)