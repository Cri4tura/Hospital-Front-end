package com.example.panacea.ui.screens.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.panacea.data.repositories.NurseRepositoryImpl
import com.example.panacea.data.repositories.RoomRepositoryImpl
import io.ktor.client.HttpClient
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json

class SplashViewModel(
    private val nurseRepository: NurseRepositoryImpl,
    private val roomRepository: RoomRepositoryImpl

) : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val isLoading: Boolean = false,
        val onSuccess: Boolean = false,
        val onError: Boolean = false
    )

    fun fetchDataFromServer() {
        viewModelScope.launch {
            state = UiState(isLoading = true)
            try {
                //repository.ping()
                nurseRepository.fetchNurseList()
                roomRepository.fetchRoomList()
                state = UiState(isLoading = false, onSuccess = true)
            } catch (e: Exception) {
                state = UiState(isLoading = false, onError = true)
                println("Error: ${e.message}")
            }
        }
    }
}