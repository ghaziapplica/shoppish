package com.example.shoppish.project.login

data class AuthUIState(
    var name : String = "",
    var email : String = "",
    var password : String = "",
    var privacyPolicy : Boolean = false,

    var nameError : Boolean = false,
    var emailError : Boolean = false,
    var passwordError : Boolean = false,
    var privacyError : Boolean = false,

)
