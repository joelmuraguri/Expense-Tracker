package com.joel.design.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.joel.design.R
import com.joel.design.WalletIcons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NavigationToolBar(
    title : String,
    popBackStack : () -> Unit
){
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center
            )},
        navigationIcon = {
            IconButton(onClick = { popBackStack() }) {
                Icon(painter = painterResource(id = WalletIcons.ArrowBack), contentDescription = stringResource(id = R.string.arrow_back_icon_description))
            }
        },
        modifier = Modifier.padding(horizontal = 16.dp)

    )
    
}