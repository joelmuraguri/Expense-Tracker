package com.joel.myapplication.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.design.R
import com.joel.design.components.EmailField
import com.joel.design.components.NameField
import com.joel.design.components.NavigationToolBar
import com.joel.design.components.PasswordField
import com.joel.design.components.SignInSignUpActionButton

@Composable
fun SignUpScreen(
    signIn : () -> Unit,
    popBackStack : () -> Unit,
    signUp: () -> Unit
){

    Scaffold(
        bottomBar = {
            SignInSignUpActionButton(
                text = R.string.sign_in_button,
                onClick = signIn
            )
        },
        topBar = {
            NavigationToolBar(
                title = R.string.create_account_top_bar_title,
                popBackStack = popBackStack
            )
        }
    ) { innerPadding ->

        SignUpContents(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            signUp = signUp
        )
    }

}

@Composable
fun SignUpContents(
    modifier: Modifier = Modifier,
    signUpViewModel: SignUpViewModel = viewModel(),
    signUp: () -> Unit
){


    val uiState by signUpViewModel.uiState

    Column(
        modifier = modifier
    ) {
        NameField(
            name = uiState.name,
            onNameValue = signUpViewModel::onNameChange)
        EmailField(
            email = uiState.email,
            onEmailValue = signUpViewModel::onEmailChange,
        )
        PasswordField(
            password = uiState.password,
            onPasswordValue = signUpViewModel::onPasswordChange,
            placeholder = R.string.password_placeholder,
        )
        PasswordField(
            password = uiState.confirmPassword,
            onPasswordValue = signUpViewModel::onPasswordConfirmChange,
            placeholder = R.string.confirm_password_placeholder,
        )
        Text(
            text = stringResource(id = R.string.terms_and_policy),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            fontSize = 12.sp,
            color = Color.LightGray
        )
        SignInSignUpActionButton(
            text = R.string.sign_up_button,
            onClick = signUp
        )
    }
}

@Preview
@Composable
fun SignUpPreview(){
    SignUpScreen(
        signIn = {},
        popBackStack = {},
        signUp = {}
    )
}