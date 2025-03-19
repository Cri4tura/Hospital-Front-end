package com.example.panacea.data.repositories

import com.example.panacea.data.network.NetworkServicesImpl
import com.example.panacea.domain.models.room.Room
import com.example.panacea.domain.repositories.RoomRepository

class RoomRepositoryImpl(
    private val conn: NetworkServicesImpl
) : RoomRepository{
    override var roomList: List<Room> = emptyList()

    override fun getCachedRoomList(): List<Room> {
        return roomList
    }

    override suspend fun fetchRoomList() {
        roomList = conn.getRooms()
    }
}

