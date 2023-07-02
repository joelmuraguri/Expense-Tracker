package com.joel.home_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val HOME_ROUTE = "home"

fun NavController.navigateToHome(navOptions: NavOptions ?= null){
    this.navigate(HOME_ROUTE, navOptions)
}

fun NavGraphBuilder.homeRoute(){
    composable(route = HOME_ROUTE){
        HomeScreen()
    }
}