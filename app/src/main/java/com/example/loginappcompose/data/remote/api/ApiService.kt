package com.example.loginappcompose.data.remote.api

import com.example.loginappcompose.data.remote.model.LoginRequest
import com.example.loginappcompose.data.remote.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Interface que define os endpoints da API.
 */

interface ApiService {

    @POST("login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}