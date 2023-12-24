package com.example.authmoduleyt.presentation.state

data class RegisterState(
    val isInputValid: Boolean = false,
    val emailInput: String = "",
    val passwordInput: String = "",
    val confirmPasswordInput: String = "",
    val isPasswordShown: Boolean = false,
    val isConfirmPasswordShown: Boolean = false,
    val errorMessageInput: String? = null,
    val isLoading: Boolean = false,
    val isRegisterSuccess: Boolean = false,
    val errorMessageRegister: String? = null
)
