package com.example.shoppish.project.neww

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.shoppish.project.MVVM.AuthViewModel
import com.example.shoppish.project.MVVM.LoginViewModel
import com.example.shoppish.project.login.ForgotPass
import com.example.shoppish.project.login.Login
import com.example.shoppish.project.login.Signup
import com.example.shoppish.project.login.Start

//import com.example.nestednavigationbottombardemo.screens.LoginContent
//import com.example.nestednavigationbottombardemo.screens.ScreenContent

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.AUTHENTICATION,
        // start with start.kt
        startDestination = AuthScreen.Start.route
    ) {
        composable(route = AuthScreen.Start.route) {
            Start(navController = navController,  viewModel = AuthViewModel(navController))
        }

        composable(route = AuthScreen.Login.route) {
            Login(navController = navController,

                viewModel = LoginViewModel(navController)
            )
        }
        composable(route = AuthScreen.SignUp.route) {
            Signup(navController = navController, authViewModel = AuthViewModel(navController))
        }
        composable(route = AuthScreen.Forgot.route) {
           ForgotPass(navController = navController,  viewModel = AuthViewModel(navController))
        }

    }
}

sealed class AuthScreen(val route: String) {
    object Start : AuthScreen(route = "START")
    object Login : AuthScreen(route = "LOGIN")
    object SignUp : AuthScreen(route = "SIGN_UP")
    object Forgot : AuthScreen(route = "FORGOT")
}