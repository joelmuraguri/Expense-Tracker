package com.joel.edit_presentation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable

const val EDIT_ROUTE = "edit"

fun NavController.navigateToEdit(navOptions: NavOptions?= null){
    this.navigate(EDIT_ROUTE, navOptions)
}

fun NavGraphBuilder.homeRoute(){
    composable(route = EDIT_ROUTE){
        EditScreen()
    }
}