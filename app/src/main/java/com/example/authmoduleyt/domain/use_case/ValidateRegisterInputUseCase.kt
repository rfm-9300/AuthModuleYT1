package com.example.authmoduleyt.domain.use_case

import com.example.authmoduleyt.domain.model.RegisterInputValidationType

class ValidateRegisterInputUseCase {
    operator fun invoke(
        email: String,
        password: String,
        confirmPassword: String
    ): RegisterInputValidationType {
        if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            return RegisterInputValidationType.EmptyField
        }
        if (!email.contains("@")) {
            return RegisterInputValidationType.NoEmail
        }
        if (password != confirmPassword) {
            return RegisterInputValidationType.NoPasswordDontMatch
        }
        if (password.length < 8) {
            return RegisterInputValidationType.PasswordTooShort
        }
        if (password.length > 20) {
            return RegisterInputValidationType.PasswordTooLong
        }
        if (!password.contains(Regex("[0-9]"))) {
            return RegisterInputValidationType.PasswordNoNumber
        }
        if (!password.contains(Regex("[A-Z]"))) {
            return RegisterInputValidationType.PasswordNoUpperCase
        }
        if (!password.contains(Regex("[a-z]"))) {
            return RegisterInputValidationType.PasswordNoLowerCase
        }
        return RegisterInputValidationType.Valid
    }
}