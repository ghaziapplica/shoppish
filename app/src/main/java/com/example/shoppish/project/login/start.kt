package com.example.shoppish.project.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.AuthViewModel
import com.example.shoppish.project.neww.AuthScreen

//import com.example.shoppish.project.MVVM.Screen

@Composable
fun Start(navController: NavHostController,
          viewModel: AuthViewModel  ,
) {



    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = viewModel.boxColor)),
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = viewModel.startlogo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Image(
            painter = painterResource(id = viewModel.startimg),
            contentDescription = "Start",
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)

        )
        Spacer(modifier = Modifier.height(60.dp))

        Button(
            modifier = Modifier
                .width(250.dp)
                .height(45.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(10.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.green),
//                contentColor = colorResource(id = R.color.white)
            ),
            onClick =  {navController.navigate(AuthScreen.SignUp.route)},
        )

         {
            Text(text = "Lets Go!",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontSize = 16.sp,
                ),
                )

        }
    }

}

//navController.navigate(Screen.SignUp.route)

@Composable
@Preview (showBackground = true)
fun StartPreview() {


        val navController = rememberNavController()
        Start(navController = navController, viewModel = AuthViewModel(navController))
    }
