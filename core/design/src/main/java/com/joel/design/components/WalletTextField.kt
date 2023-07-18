package com.joel.design.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.joel.design.R
import com.joel.design.WalletIcons

@Composable
fun EmailField(
    email : String,
    onEmailValue : (String) -> Unit,
    modifier : Modifier = Modifier
){

    OutlinedTextField(
        value = email,
        onValueChange = {
            onEmailValue(it)
        },
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                KeyboardActions()
            }
        ),
        label = {
            Text(
                text = stringResource(id = R.string.email_placeholder),
                style = MaterialTheme.typography.bodyMedium)
        })

}

@Composable
fun NameField(
    name : String,
    onNameValue : (String) -> Unit,
){
    OutlinedTextField(
        value = name,
        onValueChange = {
            onNameValue(it)
        },
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Email
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                KeyboardActions()
            }
        ),
        label ={
            Text(text = stringResource(id = R.string.name_placeholder))
        }

        )
}

@Composable
fun PasswordField(
    modifier: Modifier = Modifier,
    password : String,
    onPasswordValue : (String) -> Unit,
    @StringRes placeholder : Int

){

    val showPassword = rememberSaveable { mutableStateOf(false) }
    OutlinedTextField(
        value = password,
        onValueChange = {
            onPasswordValue(it)
        },
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        textStyle = MaterialTheme.typography.bodyMedium,
        trailingIcon = {
            if (showPassword.value) {
                IconButton(onClick = { showPassword.value = false }) {
                   Icon(
                       painter = painterResource(id = WalletIcons.Visibility),
                       contentDescription = stringResource(id = R.string.visibilty_icon_description))
                }
            } else {
                IconButton(onClick = { showPassword.value = true }) {
                    Icon(
                        painter = painterResource(id = WalletIcons.VisibilityOff),
                        contentDescription = stringResource(id = R.string.visibilty_off_icon_description))
                }
            }
        },
        visualTransformation = if (showPassword.value) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                KeyboardActions()
            }
        ),
        label ={
            Text(
                text = stringResource(id = placeholder),
                style = MaterialTheme.typography.bodyMedium)
        }
    )
}
