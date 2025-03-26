package com.example.panacea.domain.models.room
import com.example.panacea.domain.models.room.Room
import kotlinx.serialization.Serializable

@Serializable
data class RoomResponse(
    val count: Int,
    val `data`: List<Room>,
    val status: String
)