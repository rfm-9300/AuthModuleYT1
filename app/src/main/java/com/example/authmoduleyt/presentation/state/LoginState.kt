package com.example.authmoduleyt.presentation.state

data class LoginState (
    val isInputValid: Boolean = false,
    val emailInput: String = "",
    val passwordInput: String = "",
    val isPasswordShown: Boolean = false,
    val errorMessageInput: String? = null,
    val isLoading: Boolean = false,
    val isLoginSuccess: Boolean = false,
    val errorMessageLogin: String? = null
)