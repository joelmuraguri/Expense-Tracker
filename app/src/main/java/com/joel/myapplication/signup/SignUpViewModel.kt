package com.joel.myapplication.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel : ViewModel() {

    var uiState = mutableStateOf(SignUpState())
        private set


    private val name
        get() = uiState.value.name

    private val email
        get() = uiState.value.email

    private val password
        get() = uiState.value.password

    private val confirmPassword
        get() = uiState.value.confirmPassword


    fun onEmailChange(newEmail : String){
        uiState.value = uiState.value.copy(email = newEmail)
    }

    fun onPasswordChange(newPassword : String){
        uiState.value = uiState.value.copy(password = newPassword)
    }

    fun onNameChange(newName : String){
        uiState.value = uiState.value.copy(name = newName)
    }

    fun onPasswordConfirmChange(confirmPassword : String){
        uiState.value = uiState.value.copy(confirmPassword = confirmPassword)
    }

}

data class SignUpState(
    val email : String = "",
    val name : String = "",
    val password : String = "",
    val confirmPassword : String = ""
)