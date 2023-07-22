package com.joel.myapplication.signin

import androidx.compose.runtime.mutableStateOf
import com.joel.myapplication.R
import com.joel.utility.extensions.isValidEmail
import com.joel.utility.extensions.isValidPassword
import com.joel.utility.snackbar.SnackBarManager
import com.joel.utility.vm.WalletViewModel

class SignInViewModel : WalletViewModel() {

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

    fun onSignInClick(){
        if (!email.isValidEmail()){
            SnackBarManager.showMessage(R.string.invalid_email_sign_in)
            return
        }
        if (!password.isValidPassword()){
            SnackBarManager.showMessage(R.string.password_error_sign_in)
            return
        }

    }


}

data class SignInUIState(
    val email : String = "",
    val password : String = "",
)