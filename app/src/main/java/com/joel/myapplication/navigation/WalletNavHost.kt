package com.joel.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.joel.edit_presentation.editRoute
import com.joel.history_presentation.historyRoute
import com.joel.home_presentation.HOME_ROUTE
import com.joel.home_presentation.homeRoute
import com.joel.myapplication.WalletAppState
import com.joel.overview_presentation.overViewRoute
import com.joel.profile_presentation.profileRoute

@Composable
fun WalletNavHost(
    appState: WalletAppState,
    startDestination : String = HOME_ROUTE,
    modifier: Modifier = Modifier,
){

    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        homeRoute()
        overViewRoute()
        historyRoute()
        profileRoute()
        editRoute()
    }
}