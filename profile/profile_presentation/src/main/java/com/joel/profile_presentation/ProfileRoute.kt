package com.joel.profile_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val PROFILE_ROUTE = "profile"

fun NavController.navigateToProfile(navOptions: NavOptions?= null){
    this.navigate(PROFILE_ROUTE, navOptions)
}

fun NavGraphBuilder.profileRoute(){
    composable(route = PROFILE_ROUTE){
        ProfileScreen()
    }
}