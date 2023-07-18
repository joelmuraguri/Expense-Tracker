package com.joel.myapplication.welcome

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

const val WELCOME_ROUTE = "welcome"

fun NavGraphBuilder.welcomeRoute(
    guestSignIn : () -> Unit,
    googleSignIn : () -> Unit,
    signUp : () -> Unit,
    onNavToSignIn : () -> Unit
){
    composable(route = WELCOME_ROUTE){
        WelcomeScreen(
            email = "",
            guestSignIn = guestSignIn,
            googleSignIn = googleSignIn,
            signUp = signUp,
            onNavToSignIn = onNavToSignIn
        )
    }
}