package com.joel.myapplication

import android.content.res.Resources
import androidx.compose.runtime.Stable
import androidx.navigation.NavHostController
import com.joel.utility.snackbar.SnackBarManager
import com.joel.utility.snackbar.SnackBarMessage.Companion.toMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import androidx.compose.material.ScaffoldState

@Stable
class WalletAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    private val snackBarManager : SnackBarManager,
    private val resources : Resources,
    coroutineScope: CoroutineScope

) {

    init {
       coroutineScope.launch {
           snackBarManager.snackBarMessages.filterNotNull().collect{ snackBarMessage ->
               val text = snackBarMessage.toMessage(resources)
               scaffoldState.snackbarHostState.showSnackbar(text)
           }
       }
    }

//    fun popUp(){
//        navController.popBackStack()
//    }
//
//
//    fun navigate(route : String){
//        navController.navigate(route){
//            launchSingleTop = true
//        }
//    }
//
//    fun navigateAndPopUp(route: String, popUp: String) {
//        navController.navigate(route) {
//            launchSingleTop = true
//            popUpTo(popUp) { inclusive = true }
//        }
//    }
}