package com.example.authmoduleyt.domain.model

enum class RegisterInputValidationType {
    EmptyField,
    NoEmail,
    NoPasswordDontMatch,
    PasswordTooShort,
    PasswordTooLong,
    PasswordNoNumber,
    PasswordNoUpperCase,
    PasswordNoLowerCase,
    Valid
}