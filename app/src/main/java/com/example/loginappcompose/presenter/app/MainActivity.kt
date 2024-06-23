package com.example.loginappcompose.presenter.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginappcompose.presenter.app.ui.LoginScreen
import com.example.loginappcompose.presenter.app.ui.theme.LoginAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginAppComposeTheme {
                setContent {
//                    LoginScreen()
                }
            }
        }
    }
}

