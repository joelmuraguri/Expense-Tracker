package com.joel.myapplication.signin

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val SIGN_IN_ROUTE = "sign_in"


fun NavGraphBuilder.signInRoute(
    guestSignIn : () -> Unit,
    googleSignIn : () -> Unit,
    signUp : () -> Unit,
    signIn : () -> Unit,
    popBackStack : () -> Unit
){

    composable(route = SIGN_IN_ROUTE){
        SignInScreen(
            guestSignIn = { guestSignIn() },
            googleSignIn = { googleSignIn() },
            signUp = { signUp() },
            signIn = { signIn() },
            popBackStack = {popBackStack() }
        )
    }
}