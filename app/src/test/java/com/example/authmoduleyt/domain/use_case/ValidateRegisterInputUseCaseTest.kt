package com.example.authmoduleyt.domain.use_case

import com.example.authmoduleyt.domain.model.RegisterInputValidationType
import org.junit.Assert.*
import org.junit.Test

class ValidateRegisterInputUseCaseTest{
    private val validateRegisterInputUseCase = ValidateRegisterInputUseCase()

    @Test
    fun `when email is empty then return EmptyField`(){
        val result = validateRegisterInputUseCase("","password","password")
        assertTrue(result == RegisterInputValidationType.EmptyField)
    }

    @Test
    fun `when password is empty then return EmptyField`(){
        val result = validateRegisterInputUseCase("email","","password")
        assertTrue(result == RegisterInputValidationType.EmptyField)
    }

    @Test
    fun `when confirm password is empty then return EmptyField`(){
        val result = validateRegisterInputUseCase("email","password","")
        assertTrue(result == RegisterInputValidationType.EmptyField)
    }

    @Test
    fun `when email is invalid then return NoEmail`(){
        val result = validateRegisterInputUseCase("email","password","password")
        assertTrue(result == RegisterInputValidationType.NoEmail)
    }

    @Test
    fun `when password and confirm password are not the same then return NoPasswordDontMatch`(){
        val result = validateRegisterInputUseCase("email","password","password1")
        assertTrue(result == RegisterInputValidationType.NoPasswordDontMatch)
    }

    @Test
    fun `when password is too short then return PasswordTooShort`(){
        val result = validateRegisterInputUseCase("email","pass","pass")
        assertTrue(result == RegisterInputValidationType.PasswordTooShort)
    }

    @Test
    fun `when password is too long then return PasswordTooLong`(){
        val result = validateRegisterInputUseCase("email","passwordpasswordpassword","passwordpasswordpassword")
        assertTrue(result == RegisterInputValidationType.PasswordTooLong)
    }

    @Test
    fun `when password has no number then return PasswordNoNumber`(){
        val result = validateRegisterInputUseCase("email","password","password")
        assertTrue(result == RegisterInputValidationType.PasswordNoNumber)
    }

    @Test
    fun `when password has no upper case then return PasswordNoUpperCase`(){
        val result = validateRegisterInputUseCase("email","password","password")
        assertTrue(result == RegisterInputValidationType.PasswordNoUpperCase)
    }

    @Test
    fun `when password has no lower case then return PasswordNoLowerCase`(){
        val result = validateRegisterInputUseCase("email","password","password")
        assertTrue(result == RegisterInputValidationType.PasswordNoLowerCase)
    }

    @Test
    fun `when email and password are valid then return Valid`(){
        val result = validateRegisterInputUseCase("email","Password1","Password1")
        assertTrue(result == RegisterInputValidationType.Valid)
    }
}