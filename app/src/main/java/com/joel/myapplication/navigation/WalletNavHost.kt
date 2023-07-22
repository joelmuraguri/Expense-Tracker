package com.joel.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.joel.myapplication.edit.expenseRoute
import com.joel.myapplication.edit.incomeRoute
import com.joel.myapplication.home.HOME_ROUTE
import com.joel.myapplication.home.homeRoute
import com.joel.myapplication.signin.SIGN_IN_ROUTE
import com.joel.myapplication.signin.signInRoute
import com.joel.myapplication.signup.SIGN_UP_ROUTE
import com.joel.myapplication.signup.signUpRoute
import com.joel.myapplication.welcome.WELCOME_ROUTE
import com.joel.myapplication.welcome.welcomeRoute

@Composable
fun WalletNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){

    val walletNavActions = remember {
        WalletNavActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = WELCOME_ROUTE
    ){
        homeRoute(
            walletNavActions.navigateToFABRoutes
        )
        incomeRoute(
            popBackStack = {
                navController.popBackStack()
            })
        expenseRoute(
            popBackStack = {
                navController.popBackStack()
            }
        )
        welcomeRoute(
            guestSignIn = {},
            googleSignIn = {},
            signUp = {
                navController.navigate(SIGN_UP_ROUTE)
            },
            onNavToSignIn = {
                navController.navigate(SIGN_IN_ROUTE)
            }
        )
        signInRoute(
            guestSignIn = {

            },
            googleSignIn = {

            },
            signUp = {
                navController.navigate(SIGN_UP_ROUTE)
            },
            signIn = {
                navController.navigate(HOME_ROUTE)

            },
            popBackStack = {
                navController.popBackStack()
            }
        )
        signUpRoute(
            signUp = {
                navController.navigate(HOME_ROUTE)
            },
            signIn = {
                navController.navigate(SIGN_IN_ROUTE)
            },
            popBackStack = {
                navController.popBackStack()
            }
        )
    }
}