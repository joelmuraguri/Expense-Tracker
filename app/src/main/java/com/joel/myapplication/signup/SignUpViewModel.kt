package com.joel.myapplication.signup

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.joel.myapplication.R
import com.joel.utility.extensions.isValidEmail
import com.joel.utility.extensions.isValidPassword
import com.joel.utility.extensions.passwordMatches
import com.joel.utility.snackbar.SnackBarManager
import com.joel.utility.vm.WalletViewModel

class SignUpViewModel : WalletViewModel() {

    var uiState = mutableStateOf(SignUpState())
        private set


    private val name
        get() = uiState.value.name

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

    fun onNameChange(newName : String){
        uiState.value = uiState.value.copy(name = newName)
    }

    fun onPasswordConfirmChange(confirmPassword : String){
        uiState.value = uiState.value.copy(confirmPassword = confirmPassword)
    }

    fun onSignUpClick(){
        if (!email.isValidEmail()){
            SnackBarManager.showMessage(R.string.invalid_email_sign_up)
            return
        }
        if (!password.isValidPassword()){
            SnackBarManager.showMessage(R.string.password_error_sign_up)
        }

        if (!password.passwordMatches(uiState.value.confirmPassword)){
            SnackBarManager.showMessage(R.string.invalid_password_match)
        }

        launchCatching {

        }
    }

    fun onSignInAsGuest(){
        launchCatching {


        }
    }

}

data class SignUpState(
    val email : String = "",
    val name : String = "",
    val password : String = "",
    val confirmPassword : String = ""
)