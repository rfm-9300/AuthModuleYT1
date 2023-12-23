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
}