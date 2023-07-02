package com.joel.myapplication

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import androidx.tracing.trace
import com.joel.edit_presentation.EDIT_ROUTE
import com.joel.history_presentation.navigateToHistory
import com.joel.home_presentation.navigateToHome
import com.joel.myapplication.navigation.BottomBarDestinations
import com.joel.overview_presentation.navigateToOverview
import com.joel.profile_presentation.navigateToProfile

@Composable
fun rememberWalletAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
) : WalletAppState{
    return remember(
        navController, windowSizeClass
    ) {
        WalletAppState(navController, windowSizeClass)
    }

}

@Stable
class WalletAppState(
    val navController : NavHostController,
    private val windowSizeClass: WindowSizeClass
) {

    val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination


    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val bottomBarDestinationsList: List<BottomBarDestinations> = BottomBarDestinations.values().asList()

    fun navigateToTopLevelDestination(bottomBarDestinations: BottomBarDestinations) {
        trace("Navigation: ${bottomBarDestinations.name}") {
            val levelNavOptions = navOptions {
                // Pop up to the start destination of the graph to
                // avoid building up a large stack of destinations
                // on the back stack as users select items
                popUpTo(navController.graph.findStartDestination().id) {
                    saveState = true
                }
                // Avoid multiple copies of the same destination when
                // re selecting the same item
                launchSingleTop = true
                // Restore state when re selecting a previously selected item
                restoreState = true
            }

            when (bottomBarDestinations) {
                BottomBarDestinations.HOME -> navController.navigateToHome(levelNavOptions)
                BottomBarDestinations.OVERVIEW -> navController.navigateToOverview(levelNavOptions)
                BottomBarDestinations.HISTORY -> navController.navigateToHistory(levelNavOptions)
                BottomBarDestinations.PROFILE -> navController.navigateToProfile(levelNavOptions)
            }
        }
    }
}