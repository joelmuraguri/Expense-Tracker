package com.joel.myapplication.navigation

import androidx.navigation.NavHostController
import com.joel.design.widget.FABItem

class WalletNavActions(navController: NavHostController) {

    val navigateToFABRoutes : (FABItem) -> Unit = {
        navController.navigate(route = it.route)
    }

}