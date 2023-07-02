package com.joel.history_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HISTORY_ROUTE = "history"

fun NavController.navigateToHistory(navOptions: NavOptions?= null){
    this.navigate(HISTORY_ROUTE, navOptions)
}

fun NavGraphBuilder.historyRoute(){
    composable(route = HISTORY_ROUTE){
        HistoryScreen()
    }
}