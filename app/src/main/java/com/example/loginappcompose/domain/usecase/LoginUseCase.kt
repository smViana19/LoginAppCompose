package com.example.loginappcompose.domain.usecase

import com.example.loginappcompose.domain.model.User
import com.example.loginappcompose.domain.repository.AuthRepository

class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String): User {
        return repository.login(email, password)
    }
}