package com.example.authmoduleyt.presentation.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.authmoduleyt.domain.model.RegisterInputValidationType
import com.example.authmoduleyt.domain.use_case.ValidateRegisterInputUseCase
import com.example.authmoduleyt.presentation.state.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val validateRegisterInputUseCase: ValidateRegisterInputUseCase
) : ViewModel() {

var registerState by mutableStateOf(RegisterState())
    private set

fun onEmailInputChange(newValue: String){
        registerState = registerState.copy(emailInput = newValue)
        checkInputValidation()
    }

fun onPasswordInputChange(newValue: String){
        registerState = registerState.copy(passwordInput = newValue)
        checkInputValidation()
    }

fun onConfirmPasswordInputChange(newValue: String){
        registerState = registerState.copy(confirmPasswordInput = newValue)
        checkInputValidation()
    }

fun onPasswordShowHideChange(){
        registerState = registerState.copy(isPasswordShown = !registerState.isPasswordShown)
    }

fun onConfirmPasswordShowHideChange(){
        registerState = registerState.copy(isConfirmPasswordShown = !registerState.isConfirmPasswordShown)
    }

fun onRegisterClick() {

    }

private fun checkInputValidation(){
        val validationResult = validateRegisterInputUseCase(
            registerState.emailInput,
            registerState.passwordInput,
            registerState.confirmPasswordInput
        )
        processInputValidationType(validationResult)
    }

private fun processInputValidationType(type: RegisterInputValidationType){
        registerState = when(type){
            RegisterInputValidationType.EmptyField -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Field cannot be empty"
                )
            }
            RegisterInputValidationType.NoEmail -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Invalid email"
                )
            }
            RegisterInputValidationType.NoPasswordDontMatch -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password don't match"
                )
            }
            RegisterInputValidationType.PasswordTooShort -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password too short"
                )
            }
            RegisterInputValidationType.PasswordTooLong -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password too long"
                )
            }
            RegisterInputValidationType.PasswordNoNumber -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password must contain at least one number"
                )
            }
            RegisterInputValidationType.PasswordNoUpperCase -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password must contain at least one upper case"
                )
            }
            RegisterInputValidationType.Valid -> {
                registerState.copy(
                    isInputValid = true,
                    errorMessageInput = null
                )
            }
            RegisterInputValidationType.PasswordNoLowerCase -> {
                registerState.copy(
                    isInputValid = false,
                    errorMessageInput = "Password must contain at least one lower case"
                )
            }
        }
    }

}