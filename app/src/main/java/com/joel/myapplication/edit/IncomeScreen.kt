package com.joel.myapplication.edit

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import com.joel.design.components.BottomBarButton
import com.joel.design.components.NavigationToolBar
import com.joel.design.R

@Composable
fun IncomeScreen(
    popBackStack :() -> Unit
){

    Scaffold(
        topBar = {
            NavigationToolBar(
                title = R.string.add_income_top_bar_title,
                popBackStack = {
                    popBackStack()
                }
            )
        },
        bottomBar = {
            BottomBarButton(text = R.string.save_income_button)
        }
    ) {innerPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Text(
                "ADD INCOME",
                fontSize = 25.sp
            )
        }
    }
}