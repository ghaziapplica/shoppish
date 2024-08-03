package com.example.shoppish.project.login

sealed class UIEvent {
    data class NameChanged (val name: String) : UIEvent()
    data class EmailChanged (val email: String) : UIEvent()
    data class PasswordChanged (val password: String) : UIEvent()
    data class PrivacyClicked (val status: Boolean) : UIEvent()


    object SignInButtonClicked : UIEvent()
}