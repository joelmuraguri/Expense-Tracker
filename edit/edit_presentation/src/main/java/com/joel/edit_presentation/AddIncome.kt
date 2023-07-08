package com.joel.edit_presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.joel.design.components.NavigationToolBar

@Composable
fun AddIncome(onPopBackStack : () -> Unit){

    Scaffold(
        topBar = {
            NavigationToolBar(title = "Add Income") {
                onPopBackStack()
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "ADD INCOME",
                fontSize = 25.sp
            )
        }
    }

}