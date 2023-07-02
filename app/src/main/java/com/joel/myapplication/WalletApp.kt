package com.joel.myapplication

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.joel.edit_presentation.navigateToEdit
import com.joel.myapplication.navigation.BottomBarDestinations
import com.joel.myapplication.navigation.WalletNavHost
import com.joel.myapplication.navigation.WalletNavigationBar
import com.joel.myapplication.navigation.WalletNavigationBarItem
import com.joel.myapplication.navigation.WalletNavigationRail
import com.joel.myapplication.navigation.WalletNavigationRailItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun WalletApp(
    windowSizeClass: WindowSizeClass,
    appState: WalletAppState = rememberWalletAppState(windowSizeClass = windowSizeClass),
){

    Scaffold(
        containerColor = Color.Transparent,
        contentColor = MaterialTheme.colorScheme.onBackground,
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        bottomBar = {
            if (appState.shouldShowBottomBar){
                WalletBottomBar(
                    destinations = appState.bottomBarDestinationsList,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                )
            }
        },
        floatingActionButton = {
                FloatingActionButton(
                    onClick = { appState.navController.navigateToEdit() },
                    shape = RoundedCornerShape(50),
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "")
                }
        },
        floatingActionButtonPosition = FabPosition.Center

    ) { paddingValues ->

        Row(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .consumeWindowInsets(paddingValues)
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal,
                    ),
                ),
        ) {
            if (appState.shouldShowNavRail) {
                WalletNavRail(
                    destinations = appState.bottomBarDestinationsList,
                    onNavigateToDestination = appState::navigateToTopLevelDestination,
                    currentDestination = appState.currentDestination,
                    modifier = Modifier
                        .safeDrawingPadding(),
                )
            }
            Column(Modifier.fillMaxSize()) {
                WalletNavHost(appState = appState)
            }
        }
    }
}

@Composable
fun WalletNavRail(
    destinations: List<BottomBarDestinations>,
    onNavigateToDestination: (BottomBarDestinations) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
){

    WalletNavigationRail(modifier = modifier) {
        destinations.forEach { destinations ->
            val selected = currentDestination.isBottomBarDestinationInHierarchy(destinations)
            WalletNavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destinations) },
                icon = {
                    Icon(
                        painter = painterResource(id = destinations.icon),
                        contentDescription = "")

                },
                label = {  },
            )
        }
    }
}

@Composable
fun WalletBottomBar(
    destinations: List<BottomBarDestinations>,
    onNavigateToDestination: (BottomBarDestinations) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier,
){

    WalletNavigationBar(modifier = modifier) {
        destinations.forEach { destinations ->
            val selected = currentDestination.isBottomBarDestinationInHierarchy(destinations)
            WalletNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destinations) },
                icon = {
                       Icon(
                           painter = painterResource(id = destinations.icon),
                           contentDescription = "")

                },
                label = {  },

                )
        }

    }

}

private fun NavDestination?.isBottomBarDestinationInHierarchy(destination: BottomBarDestinations) =
    this?.hierarchy?.any {
        it.route?.contains(destination.name, true) ?: false
    } ?: false