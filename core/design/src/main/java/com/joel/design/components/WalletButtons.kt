package com.joel.design.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun SignInSignUpActionButton(
    @StringRes text : Int,
    onClick: () -> Unit
){

    Button(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = stringResource(id = text))
    }

}

@Composable
fun GuestAndGoogleOutlinedButton(
    @StringRes text : Int,
    onClick : () -> Unit
){

    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(text = stringResource(id = text))
    }

}