package com.joel.myapplication.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.joel.design.widget.FABItem

const val HOME_ROUTE = "home_route"

fun NavGraphBuilder.homeRoute(
    onFABRoutes : (FABItem) -> Unit

){
    composable(route = HOME_ROUTE){
        HomeScreen(
            onFABRoutes = {
                onFABRoutes(it)
            }
        )
    }

}