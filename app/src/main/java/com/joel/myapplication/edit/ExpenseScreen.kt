package com.joel.myapplication.edit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.joel.design.R
import com.joel.design.components.BottomBarButton
import com.joel.design.components.NavigationToolBar

@Composable
fun ExpenseScreen(
    popBackStack :() -> Unit

){

    Scaffold(
        topBar = {
            NavigationToolBar(
                title = R.string.add_expense_top_bar_title,
                popBackStack = {
                    popBackStack()
                }
            )
        },
        bottomBar = {
            BottomBarButton(text = R.string.save_expense_button)
        }
    ) {innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Text(
                "ADD EXPENSE",
                fontSize = 25.sp
            )
        }
    }
}