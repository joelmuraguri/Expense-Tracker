package com.joel.myapplication.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.design.components.EmailField
import com.joel.design.components.NavigationToolBar
import com.joel.design.components.PasswordField
import com.joel.design.components.SignInSignUpActionButton
import com.joel.myapplication.welcome.WelcomeOutlinedButtons

@Composable
fun SignInScreen(
    guestSignIn : () -> Unit,
    googleSignIn : () -> Unit,
    signUp : () -> Unit,
    signIn : () -> Unit,
    popBackStack : () -> Unit
){

    Scaffold(
        topBar = {
            NavigationToolBar(
                title = com.joel.design.R.string.sign_in_top_bar_title,
                popBackStack = popBackStack
            )
        },
        bottomBar = {
            SignInSignUpActionButton(
                text = com.joel.design.R.string.sign_up_button_o,
                onClick = signUp
            )
        }
    ) { innerPadding ->

        SignInContents(
            modifier = Modifier
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            guestSignIn = guestSignIn,
            googleSignIn = googleSignIn,
            signIn = signIn
        )

    }
}


@Composable
fun SignInContents(
    modifier: Modifier = Modifier,
    signInViewModel: SignInViewModel = viewModel(),
    guestSignIn : () -> Unit,
    googleSignIn : () -> Unit,
    signIn : () -> Unit
){
    val uiState by signInViewModel.uiState


    Column(
        modifier = modifier
    ) {
        EmailField(
            email = uiState.email,
            onEmailValue = signInViewModel::onEmailChange,
        )
        PasswordField(
            password = uiState.password,
            onPasswordValue = signInViewModel::onPasswordChange,
            placeholder = com.joel.design.R.string.password_placeholder,
        )
        SignInSignUpActionButton(
            text = com.joel.design.R.string.sign_in_button,
            onClick = {
                signInViewModel.onSignInClick()
            }
        )
        Text(
            text = stringResource(id = com.joel.design.R.string.or_text),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            color = Color.LightGray,
        )
        WelcomeOutlinedButtons(
            guestSignIn, googleSignIn
        )
    }
}

@Preview
@Composable
fun SignInPreview(){
    SignInScreen(
        guestSignIn ={}, googleSignIn ={}, signUp ={}, signIn ={}, popBackStack ={}
    )
}