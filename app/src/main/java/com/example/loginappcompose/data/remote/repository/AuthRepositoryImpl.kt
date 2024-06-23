package com.example.loginappcompose.data.remote.repository

import com.example.loginappcompose.data.remote.api.ApiService
import com.example.loginappcompose.data.remote.mapper.LoginResponseMapper
import com.example.loginappcompose.data.remote.model.LoginRequest
import com.example.loginappcompose.domain.model.User
import com.example.loginappcompose.domain.repository.AuthRepository
import javax.inject.Inject

/**
 * Implementação do repository de autenticação que usa o ApiService para realizar a autenticação.
 */

class AuthRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val mapper: LoginResponseMapper
) : AuthRepository {
    override suspend fun login(email: String, password: String): User {
        val response = api.login(LoginRequest(email, password))
        return mapper.mapFromEntity(response)
    }
}