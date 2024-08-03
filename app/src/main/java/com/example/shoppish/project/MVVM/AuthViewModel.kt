package com.example.shoppish.project.MVVM

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.shoppish.R
import com.example.shoppish.project.login.AuthUIState
import com.example.shoppish.project.login.Rules.Validator
import com.example.shoppish.project.login.UIEvent
import com.example.shoppish.project.neww.Graph
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel(
    private val navController: NavController
) : ViewModel() {
// for start screen

    val startlogo = R.drawable.logoshoppish
    val startimg = R.drawable.startimg
    val boxColor = R.color.box_color

    // for signin screen

    var password = ""
    val outlinedTextField = mutableStateOf("")
    val outlinedEmailField = mutableStateOf("")
    val outlinedPassField = mutableStateOf("")
    val passwordVisible = mutableStateOf(false)
    val textField = mutableStateOf("")
    val passField = mutableStateOf("")
    val emailField = mutableStateOf("")
    val googleIcon = R.drawable.google
    val facebookIcon = R.drawable.facebookicon
    val already = "Already have an account?"
    val orSignup = "Or sign up with social account"
    // for login screen


    //for forgot screen

    val forgotText = "Forgot password?"
    val plzEnter = "Please, enter your email address. " +
            "You will receive a link to create a new password via email."

    private val TAG  = AuthViewModel::class.simpleName

    val authUIState = mutableStateOf(AuthUIState())
    var allValidationPassed = mutableStateOf(false)
    var signupInProgress = mutableStateOf(false)
    fun onEvent (event: UIEvent) {
        when(event){
            is UIEvent.NameChanged -> {
                authUIState.value = authUIState.value.copy(
                    name = event.name
                )
                validateDataWithRules()

                printState()
            }
            is UIEvent.EmailChanged -> {
                authUIState.value = authUIState.value.copy(
                    email = event.email
                )
                validateDataWithRules()

                printState()
            }
            is UIEvent.PasswordChanged -> {
                authUIState.value = authUIState.value.copy(
                    password = event.password
                )
                validateDataWithRules()

                printState()
            }
            is UIEvent.SignInButtonClicked -> {
                signup()
            }
            is UIEvent.PrivacyClicked -> {
                    authUIState.value = authUIState.value.copy(
                        privacyPolicy = event.status
                    )
                validateDataWithRules()
            }
        }
    }

    private fun signup() {
        createUserInFireBase(
            email = authUIState.value.email,
            password = authUIState.value.password,
        )
    }

    private fun validateDataWithRules() {
        val nameResult = Validator.validateName(
            name = authUIState.value.name
        )
        val emailResult = Validator.validateEmail(
            email = authUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = authUIState.value.password
        )
        val PrivacyResult = Validator.validatePrivacy(
            statusValue = authUIState.value.privacyPolicy
        )

        authUIState.value = authUIState.value.copy(
            nameError = nameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyError = PrivacyResult.status

        )
        allValidationPassed.value = nameResult.status && emailResult.status && passwordResult.status
                && PrivacyResult.status

    }
            private fun printState(){
                Log.d(TAG, "Inside_printState")
                Log.d(TAG, authUIState.value.toString())
    }

    private fun createUserInFireBase(password: String, email: String) {
        signupInProgress.value = true
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {
               it.isSuccessful
                signupInProgress.value = false
                if (it.isSuccessful) {
                    navController.navigate(Graph.HOME) {
                        popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                    }
                }
            }
            .addOnFailureListener{
                it.localizedMessage
            }
    }

}

