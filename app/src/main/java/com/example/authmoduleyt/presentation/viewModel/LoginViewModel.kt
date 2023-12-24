package com.example.authmoduleyt.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authmoduleyt.domain.model.LoginInputValidationType
import com.example.authmoduleyt.domain.repository.AuthRepository
import com.example.authmoduleyt.domain.use_case.ValidateLoginInputUseCase
import com.example.authmoduleyt.presentation.state.LoginState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateLoginInputUseCase: ValidateLoginInputUseCase,
    private val authRepository: AuthRepository

) : ViewModel() {
    var loginState by mutableStateOf(LoginState())
    private set

    fun onEmailInputChange(newValue: String){
        loginState = loginState.copy(emailInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String){
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onPasswordShowHideChange(){
        loginState = loginState.copy(isPasswordShown = !loginState.isPasswordShown)
    }

    fun onLoginClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            val result = authRepository.login(
                loginState.emailInput,
                loginState.passwordInput
            )
            loginState = loginState.copy(isLoading = false)
            loginState = if(result){
                loginState.copy(isLoginSuccess = true)
            }else{
                loginState.copy(errorMessageLogin = "An error occurred")
            }
        }
    }

    private fun checkInputValidation(){
        val validationResult = validateLoginInputUseCase(
            loginState.emailInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: LoginInputValidationType){
        loginState = when(type){
            LoginInputValidationType.EmptyField -> {
                loginState.copy(
                    isInputValid = false,
                    errorMessageInput = "Field cannot be empty"
                )
            }
            LoginInputValidationType.NoEmail -> {
                loginState.copy(
                    isInputValid = false,
                    errorMessageInput = "Invalid email"
                )
            }
            LoginInputValidationType.Valid -> {
                loginState.copy(
                    isInputValid = true,
                    errorMessageInput = null
                )
            }
    }
}
}