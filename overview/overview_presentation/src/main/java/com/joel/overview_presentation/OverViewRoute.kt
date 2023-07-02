package com.joel.overview_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val OVERVIEW_ROUTE = "overview"

fun NavController.navigateToOverview(navOptions: NavOptions?= null){
    this.navigate(OVERVIEW_ROUTE, navOptions)
}

fun NavGraphBuilder.overViewRoute(){
    composable(route = OVERVIEW_ROUTE){
        OverViewScreen()
    }
}