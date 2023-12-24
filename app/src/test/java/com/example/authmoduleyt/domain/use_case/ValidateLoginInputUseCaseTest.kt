package com.example.authmoduleyt.domain.use_case

import com.example.authmoduleyt.domain.model.LoginInputValidationType
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ValidateLoginInputUseCaseTest {
    private val validateLoginInputUseCase = ValidateLoginInputUseCase()

    @Test
    fun `when email is empty then return EmptyField`() {
        val result = validateLoginInputUseCase("", "password")
        assertThat(result == LoginInputValidationType.EmptyField)
    }

    @Test
    fun `when password is empty then return EmptyField`() {
        val result = validateLoginInputUseCase("riusd@lkd.com", "")
        assertThat(result == LoginInputValidationType.EmptyField)
    }

    @Test
    fun `when email is invalid then return InvalidEmail`() {
        val result = validateLoginInputUseCase("riusd", "password")
        assertThat(result == LoginInputValidationType.NoEmail)
    }

    @Test
    fun `when email and password are valid then return Valid`() {
        val result = validateLoginInputUseCase("wdwdw", "password")
        assertThat(result == LoginInputValidationType.Valid)
    }


}