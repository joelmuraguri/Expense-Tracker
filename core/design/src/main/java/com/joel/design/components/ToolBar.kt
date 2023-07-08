package com.joel.design.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.joel.design.R
import com.joel.design.WalletIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationToolBar(
    title : String,
    popBackStack : () -> Unit
){
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center
            )},
        navigationIcon = {
            IconButton(onClick = { popBackStack() }) {
                Icon(painter = painterResource(id = WalletIcons.ArrowBack), contentDescription = stringResource(id = R.string.arrow_back_icon_description))
            }
        }
    )
    
}