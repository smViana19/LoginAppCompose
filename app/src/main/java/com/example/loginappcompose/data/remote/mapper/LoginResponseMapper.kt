package com.example.loginappcompose.data.remote.mapper

import com.example.loginappcompose.data.remote.model.LoginRequest
import com.example.loginappcompose.data.remote.model.LoginResponse
import com.example.loginappcompose.domain.model.User
import javax.inject.Inject


/**
 * Mapper responsável por converter o LoginResponse recebido da API para a model de domain User.
 */
class LoginResponseMapper  @Inject constructor(){
    /**
     * Mapeia um LoginResponse para um User.
     *
     * @param entity LoginResponse recebido da API.
     * @return User objeto da model de domain.
     */

    fun mapFromEntity(entity: LoginResponse): User {
        return User(
            token = entity.token,
            userId = entity.userId
        )
    }
}