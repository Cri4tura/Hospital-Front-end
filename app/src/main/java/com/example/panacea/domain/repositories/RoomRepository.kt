package com.example.panacea.domain.repositories

import com.example.panacea.domain.models.room.Room

interface RoomRepository {
    var roomList: List<Room>
    fun getCachedRoomList(): List<Room>

    suspend fun fetchRoomList()
}