package com.joel.myapplication.navigation

import androidx.navigation.NavHostController
import com.joel.design.widget.FABItem
import com.joel.myapplication.home.HOME_ROUTE
import com.joel.myapplication.signin.SIGN_IN_ROUTE
import com.joel.myapplication.signup.SIGN_UP_ROUTE

class WalletNavActions(navController: NavHostController) {

    val navigateToFABRoutes : (FABItem) -> Unit = {
        navController.navigate(route = it.route)
    }

}