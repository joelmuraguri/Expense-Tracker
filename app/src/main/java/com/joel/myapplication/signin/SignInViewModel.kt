package com.joel.myapplication.signin

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignInViewModel : ViewModel() {

    var uiState = mutableStateOf(SignInUIState())
        private set


    private val email
        get() = uiState.value.email

    private val password
        get() = uiState.value.password


    fun onEmailChange(newEmail : String){
        uiState.value = uiState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword : String){
        uiState.value = uiState.value.copy(password = newPassword)
    }


}

data class SignInUIState(
    val email : String = "",
    val password : String = "",
)