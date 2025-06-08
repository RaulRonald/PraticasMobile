package com.example.numbergenerator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class NumberViewModel : ViewModel() {
    var uiState by mutableStateOf<NumberUiState>(NumberUiState.Idle)
        private set

    fun generateNumber() = viewModelScope.launch {
        uiState = NumberUiState.Loading
        simulateLoading()
        uiState = NumberUiState.Success(randomValue())
    }

    private suspend fun simulateLoading() {
        delay(2000)
    }

    private fun randomValue(): Int = Random.nextInt(from = 1, until = 101)
}