package com.joel.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.joel.myapplication.navigation.WalletNavHost
import com.joel.myapplication.signin.SignInScreen
import com.joel.myapplication.signup.SignUpScreen
import com.joel.myapplication.splash.SplashScreen
import com.joel.myapplication.ui.theme.WalletTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    SplashScreen(email = "")
//                    SignInScreen()
//                    SignUpScreen()
                }
            }
        }
    }
}

