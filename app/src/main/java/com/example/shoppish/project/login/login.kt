package com.example.shoppish.project.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.ComponentsUI.ButtonComponent
import com.example.shoppish.project.ComponentsUI.EmailTextField
import com.example.shoppish.project.ComponentsUI.PasswordTextField
import com.example.shoppish.project.MVVM.AuthViewModel
import com.example.shoppish.project.MVVM.LoginViewModel
import com.example.shoppish.project.neww.AuthScreen
//import com.example.shoppish.project.MVVM.Screen
import com.example.shoppish.ui.theme.poppinsFamilyFont

@Composable
fun Login (navController: NavController,
           viewModel: LoginViewModel
) {

    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id = viewModel.boxColor))
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 50.dp, end = 16.dp) // Adjust paddings as needed
            ) {
                IconButton(
                    onClick = {  },
                ) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowLeft, // Replace with your desired back arrow icon
                        contentDescription = null,
                        modifier = Modifier.size(40.dp) // Adjust icon size as needed
                    )
                }
                Spacer(modifier = Modifier.weight(1f)) // Expands space between icon and end of row
            }
            Spacer(modifier = Modifier.height(16.dp)) // Spacing between arrow and content
            // Add your content composables here
            Text(
                text = "Login",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontFamily = poppinsFamilyFont,
                fontWeight = FontWeight.Bold,
                fontSize = 39.sp
            )



            Spacer(modifier = Modifier.height(73.dp)) // Spacing between content and button

            EmailTextField(labelValue = "Email", onTextSelected = {
                viewModel.onEvent(LoginUIEvent.EmailChanged(it))

            },
                errorStatus = viewModel.loginUIState.value.emailError)
            Spacer(modifier = Modifier.height(8.dp)) // Spacing between content and button
            PasswordTextField(labelValue = "Password", onTextSelected = {
                viewModel.onEvent(LoginUIEvent.PasswordChanged(it))
            },
                errorStatus = viewModel.loginUIState.value.passwordError)

            Spacer(modifier = Modifier.height(6.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = viewModel.forgot,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .offset(x = (100.dp))
                        .clickable {
                            navController.navigate(AuthScreen.Forgot.route)

                        }

                )
                IconButton(
                    onClick = { /* Your back button action */ },
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrowright),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                        // Adjust icon size as needed
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))

            ButtonComponent(
                isEnabled = viewModel.allValidationPassed.value,
                onButtonClicked = {
                                  viewModel.onEvent(LoginUIEvent.LoginButtonClicked)
                },
                text = "Login"
            )


            Spacer(modifier = Modifier.height(194.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = viewModel.dontHave , )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(92.dp, 64.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(25.dp))
                        .background(Color.White, shape = RoundedCornerShape(25.dp)),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        painter =  painterResource(id =viewModel.googleIcon ),
                        contentDescription = "Camera Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { /* Handle camera icon click */ }
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .size(92.dp, 64.dp)
                        .shadow(elevation = 3.dp, shape = RoundedCornerShape(25.dp))
                        .background(Color.White, shape = RoundedCornerShape(25.dp)),
                    contentAlignment = Alignment.Center

                ) {
                    Image(
                        painter =  painterResource(id =viewModel.facebookIcon ),
                        contentDescription = "Camera Icon",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { /* Handle camera icon click */ }
                    )
                }
            }

        }
        if(viewModel.loginProgress.value){
            CircularProgressIndicator()
        }
    }


}


// navController.navigate(Screen.SignUp.route)
// navController.navigate(Screen.Forgot.route)
// navController.navigate(route = Screen.Bottom.route)


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    Login(navController, viewModel())
}