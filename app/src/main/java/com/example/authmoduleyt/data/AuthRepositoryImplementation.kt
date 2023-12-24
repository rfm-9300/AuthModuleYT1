package com.example.authmoduleyt.data

import com.example.authmoduleyt.domain.repository.AuthRepository

class AuthRepositoryImplementation: AuthRepository {

    override suspend fun login(email: String, password: String): Boolean {
        return true
    }

    override suspend fun register(email: String, password: String, confirmPassword: String): Boolean {
        return true
    }
}