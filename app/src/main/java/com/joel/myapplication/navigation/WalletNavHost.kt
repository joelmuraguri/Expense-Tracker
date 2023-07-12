package com.joel.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.joel.myapplication.edit.expenseRoute
import com.joel.myapplication.edit.incomeRoute
import com.joel.myapplication.home.HOME_ROUTE
import com.joel.myapplication.home.homeRoute

@Composable
fun WalletNavHost(){

    val navController = rememberNavController()

    val walletNavActions = remember {
        WalletNavActions(navController)
    }

    NavHost(
        navController = navController,
        startDestination = HOME_ROUTE
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
    }
}