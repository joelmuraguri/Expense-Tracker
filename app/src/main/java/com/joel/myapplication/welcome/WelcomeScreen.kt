package com.joel.myapplication.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.joel.design.R
import com.joel.design.components.EmailField
import com.joel.design.components.GuestAndGoogleOutlinedButton
import com.joel.design.components.SignInSignUpActionButton

@Composable
fun WelcomeScreen(
    email: String,
    splashViewModel: WelcomeViewModel = viewModel()
){

    val showBrand by remember {
        mutableStateOf(true)
    }

    Scaffold(
        bottomBar = {
            SignInSignUpActionButton(text = R.string.sign_up_button_o)
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(1f, fill = showBrand)
                        .animateContentSize()
                )

                AnimatedVisibility(
                    showBrand,
                    Modifier.fillMaxWidth()
                ) {
                    Branding(
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                    )
                }

                Spacer(
                    modifier = Modifier
                        .weight(1f, fill = showBrand)
                        .animateContentSize()
                )
                WelcomeContents(email = email, splashViewModel = splashViewModel)
            }
        }
    }


}

@Composable
fun WelcomeContents(
    email : String,
    splashViewModel: WelcomeViewModel,
    modifier: Modifier = Modifier
){

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        EmailField(
            email = email,
            onEmailValue = splashViewModel::onEmailChange
        )
        SignInSignUpActionButton(text = R.string.continue_button)

        Text(
            text = stringResource(id = R.string.or_text),
            modifier = Modifier
                .padding(vertical = 16.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 20.sp,
            color = Color.LightGray,
        )

        WelcomeOutlinedButtons()
    }
}


@Composable
fun WelcomeOutlinedButtons(){

    Column {
        GuestAndGoogleOutlinedButton(text = R.string.sign_in_as_guest_button)
        GuestAndGoogleOutlinedButton(text = R.string.sign_in_with_google_button)
    }
}
@Composable
private fun Branding(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .wrapContentHeight(align = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Logo(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(horizontal = 56.dp)
        )
        Text(
            text = stringResource(id = R.string.app_motto),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding()
                .fillMaxWidth()
        )
    }
}
@Composable
private fun Logo(
    modifier: Modifier
){

    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.wallet),
            contentDescription = stringResource(id = R.string.wallet_image),
            modifier.size(150.dp),

        )
    }
}

@Preview
@Composable
fun WelcomePreview(){
    val email = ""
    WelcomeScreen(email = email)
}