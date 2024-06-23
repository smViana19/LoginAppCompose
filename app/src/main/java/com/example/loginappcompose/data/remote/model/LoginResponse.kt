package com.example.loginappcompose.data.remote.model
/**
 * Representa a resposta de login recebida da API.
 */
data class LoginResponse(
    val token: String,
    val userId: String
)
