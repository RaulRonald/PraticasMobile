package com.example.numbergenerator

sealed interface NumberUiState {
    object Idle : NumberUiState
    object Loading : NumberUiState
    data class Success(val value: Int) : NumberUiState
    data class Failure(val errorMessage: String) : NumberUiState
}