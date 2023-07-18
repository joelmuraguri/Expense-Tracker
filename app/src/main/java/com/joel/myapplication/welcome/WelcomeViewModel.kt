package com.joel.myapplication.welcome

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    var uiState = mutableStateOf(SplashState())
        private set


    private val email
        get() = uiState.value.email


    fun onEmailChange(newEmail : String){
        uiState.value = uiState.value.copy(email = newEmail)
    }
}

data class SplashState(
    val email : String = ""
)