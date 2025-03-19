package com.example.panacea.ui.screens.home


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panacea.data.repositories.NurseRepositoryImpl
import com.example.panacea.data.repositories.RoomRepositoryImpl
import kotlinx.coroutines.launch
import com.example.panacea.domain.models.nurse.Nurse
import com.example.panacea.domain.models.room.Room
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel(
    private val nurseRepository: NurseRepositoryImpl,
    private val roomRepository: RoomRepositoryImpl
) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    var data by mutableStateOf(UiData())
        private set

    init {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            data = UiData(
                roomList = roomRepository.getCachedRoomList(),
                currentUser = nurseRepository.getCurrentUser()
            )
            state = UiState(isLoading = false, onSuccess = true)
        }
    }

    data class UiState(
        var isLoading: Boolean = false,
        val onError: Boolean = false,
        var onSuccess: Boolean = false
    )

    data class UiData(
        val roomList: List<Room> = emptyList(),
        val currentUser: Nurse? = null
    )

}