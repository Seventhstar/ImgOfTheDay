package com.seventhstar.imgoftheday.viewmodel

import com.seventhstar.imgoftheday.model.Wish

sealed class AppState {
    data class Success(val wishesData: List<Wish>) : AppState()
    data class Error(val error: Throwable) : AppState()
    object Loading : AppState()
}
