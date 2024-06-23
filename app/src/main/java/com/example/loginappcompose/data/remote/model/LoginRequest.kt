package com.example.loginappcompose.data.remote.model
/**
 * Representa a solicitação de login enviada para a API.
 */
data class LoginRequest(
    val email: String,
    val password: String
)
