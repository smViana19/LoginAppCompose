package com.example.loginappcompose.presenter.app.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginappcompose.presenter.features.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint


@Composable
fun LoginScreen(modifier: Modifier = Modifier,
                viewModel: AuthViewModel
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val loginState by viewModel.loginState
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.login(email, password) }) {
            Text("Login")
        }
        when (loginState) {
            is AuthViewModel.LoginState.Loading -> {
                CircularProgressIndicator()
            }

            is AuthViewModel.LoginState.Success -> {
                val userId = (loginState as AuthViewModel.LoginState.Success).userId
                Text("Logged in as: $userId")
            }

            is AuthViewModel.LoginState.Error -> {
                val error = (loginState as AuthViewModel.LoginState.Error).error
                Text("Error: $error")
            }

            null -> TODO()
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {


}