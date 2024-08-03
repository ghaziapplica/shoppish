package com.example.shoppish.project.MVVM
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.shoppish.R
import com.example.shoppish.project.login.LoginUIEvent
import com.example.shoppish.project.login.LoginUIState
import com.example.shoppish.project.login.Rules.Validator
import com.example.shoppish.project.neww.Graph
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(
    private val navController: NavController
) : ViewModel() {

    private val TAG  = AuthViewModel::class.simpleName
    var loginUIState = mutableStateOf(LoginUIState())
    var allValidationPassed = mutableStateOf(false)
    var loginProgress = mutableStateOf(false)

    val boxColor = R.color.box_color
    val forgot = "Forgot your password?"
    val dontHave = "Don't have an account?"
    val googleIcon = R.drawable.google
    val facebookIcon = R.drawable.facebookicon
    fun onEvent(event: LoginUIEvent) {
        when (event) {
            is LoginUIEvent.EmailChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    email = event.email
                )
            }
            is LoginUIEvent.PasswordChanged -> {
                loginUIState.value = loginUIState.value.copy(
                    password = event.password
                )
//
            }
            is LoginUIEvent.LoginButtonClicked -> {
                login()
            }
        }
        validateLoginDataWithRules()

    }


    private fun validateLoginDataWithRules(){
        val emailResult = Validator.validateEmail(
            email = loginUIState.value.email
        )
        val passwordResult = Validator.validatePassword(
            password = loginUIState.value.password
        )
        loginUIState.value = loginUIState.value.copy(
            emailError = emailResult.status,
            passwordError = passwordResult.status,
        )
        allValidationPassed.value = emailResult.status && passwordResult.status


    }
    private fun login() {
        loginProgress.value = true
        val email = loginUIState.value.email
        val password = loginUIState.value.password
     FirebaseAuth.getInstance()
         .signInWithEmailAndPassword(email,password)
         .addOnCompleteListener {

            it.isSuccessful
             if (it.isSuccessful){
                 loginProgress.value = false
                 navController.navigate(Graph.HOME) {
                     popUpTo(Graph.AUTHENTICATION) { inclusive = true }
                 }
             }
         }
         .addOnFailureListener{
            it.localizedMessage
             loginProgress.value = false

         }

    }
    }





