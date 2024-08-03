package com.example.shoppish.project.login.Rules

object Validator {
    fun validateName (name : String ) : ValidationResult{
        return ValidationResult(
            (!name.isNullOrEmpty() && name.length > 5)
        )
    }
    fun validateEmail (email : String ) : ValidationResult{
        return ValidationResult(
            (!email.isNullOrEmpty() )
        )
    }
    fun validatePassword (password : String ) : ValidationResult{
        return ValidationResult(
                (!password.isNullOrEmpty())
        )
    }

    fun validatePrivacy (statusValue : Boolean ) : ValidationResult{
        return ValidationResult(
            statusValue
        )
    }
}

data class ValidationResult (
    val status : Boolean  = false
)