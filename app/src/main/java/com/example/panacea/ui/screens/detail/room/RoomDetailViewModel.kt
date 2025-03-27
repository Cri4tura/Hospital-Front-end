package com.example.panacea.ui.screens.detail.room

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panacea.data.repositories.RoomRepositoryImpl
import com.example.panacea.domain.models.room.Room
import kotlinx.coroutines.launch

class RoomDetailViewModel(
    private val roomId: Int,
    private val repository: RoomRepositoryImpl
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    var data by mutableStateOf(UiData())
        private set

    init {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            val roomList = repository.getCachedRoomList()
            val roomToShow = roomList.find { it.id == roomId }
            data = UiData(room = roomToShow)
            state = UiState(isLoading = false)
        }
    }

    data class UiState(
        val isLoading: Boolean = false,
    )

    data class UiData(
        val room: Room? = null,
    )
}