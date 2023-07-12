package com.joel.myapplication.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.joel.design.widget.CollapsibleFAB
import com.joel.design.widget.CollapsibleFABState
import com.joel.design.widget.FABItem
import com.joel.myapplication.edit.EXPENSE_ROUTE
import com.joel.myapplication.edit.INCOME_ROUTE

@Composable
fun HomeScreen(
    onFABRoutes : (FABItem) -> Unit
){

    var collapsibleFABState by remember {
        mutableStateOf(CollapsibleFABState.Collapsed)
    }

    val fabItems = listOf(
        FABItem(
            label = "Add Income",
            route = INCOME_ROUTE
        ),
        FABItem(
            label = "Add Expense",
            route = EXPENSE_ROUTE
        ),
    )

    Scaffold(
        floatingActionButton = {
            CollapsibleFAB(
                collapsibleFABState = collapsibleFABState,
                onCollapsibleFABChange = {
                    collapsibleFABState = it
                },
                items = fabItems,
                onFABRoutes = { fabItem ->
                    onFABRoutes(fabItem)
                }
            )
        }
    ) { innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Text(
                "WALLET",
                fontSize = 25.sp
            )
        }
    }
}