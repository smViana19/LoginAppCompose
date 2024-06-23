package com.example.loginappcompose.di

import com.example.loginappcompose.data.remote.api.ApiService
import com.example.loginappcompose.data.remote.mapper.LoginResponseMapper
import com.example.loginappcompose.data.remote.repository.AuthRepositoryImpl
import com.example.loginappcompose.domain.repository.AuthRepository
import com.example.loginappcompose.domain.usecase.LoginUseCase
import dagger.Provides

object AppModule {
    @Provides
    fun provideAuthRepository(apiService: ApiService, mapper: LoginResponseMapper): AuthRepository {
        return AuthRepositoryImpl(apiService, mapper)
    }

    @Provides
    fun provideLoginUseCase(repository: AuthRepository): LoginUseCase {
        return LoginUseCase(repository)
    }
}