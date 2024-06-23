package com.example.loginappcompose.domain.repository

import com.example.loginappcompose.domain.model.User

interface AuthRepository {
    suspend fun login(email: String, password: String): User
}