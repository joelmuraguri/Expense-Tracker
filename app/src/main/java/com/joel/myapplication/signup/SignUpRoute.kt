package com.joel.myapplication.signup

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SIGN_UP_ROUTE = "sign_up"


fun NavGraphBuilder.signUpRoute(
    signUp : () -> Unit,
    signIn : () -> Unit,
    popBackStack : () -> Unit
){
    composable(route = SIGN_UP_ROUTE){
        SignUpScreen(
            signIn = { signIn() },
            popBackStack = { popBackStack() },
            signUp = {
                signUp()
            }
        )
    }
}