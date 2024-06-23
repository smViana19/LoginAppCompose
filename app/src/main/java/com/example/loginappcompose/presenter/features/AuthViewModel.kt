package com.example.loginappcompose.presenter.features

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.loginappcompose.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val loginUseCase: LoginUseCase): ViewModel() {

    sealed class LoginState {
        object Loading : LoginState()
        data class Success(val userId: String) : LoginState()
        data class Error(val error: String) : LoginState()
    }
    private val _loginState = mutableStateOf<LoginState?>(null)
    val loginState: State<LoginState?> = _loginState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _loginState.value = LoginState.Loading
            try {
                val user = loginUseCase(email, password)
            } catch (e: Exception) {
                _loginState.value = LoginState.Error(e.message ?: "Deu erro ao logar")
            }
        }
    }
}