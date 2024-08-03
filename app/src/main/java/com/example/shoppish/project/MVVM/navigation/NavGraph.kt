package com.example.shoppish.project.MVVM.navigation
//
//import androidx.compose.runtime.Composable
//import androidx.navigation.compose.NavHost
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import com.example.shoppish.project.MVVM.Screen
//import com.example.shoppish.project.login.ForgotPass
//import com.example.shoppish.project.login.Login
//import com.example.shoppish.project.login.Signup
//import com.example.shoppish.project.login.Start
//
//@Composable
//
//fun NavGraph(navController: NavHostController) {
//
//    NavHost(
//        navController = navController,
//        startDestination = Screen.Start.route
//    )
//    {
//        composable(Screen.SignUp.route) {
//            Signup( navController)
//        }
//        composable(Screen.Login.route) {
//            Login(navController)
//        }
//        composable(Screen.Start.route) {
//            Start(navController)
//        }
//        composable(Screen.Forgot.route) {
//            ForgotPass(navController)
//        }
//        composable(Screen.Bottom.route) {
//            Navigation( navController)
//        }
//
//
//
//    }
//}