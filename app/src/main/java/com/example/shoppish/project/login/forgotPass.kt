package com.example.shoppish.project.login


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.AuthViewModel
import com.example.shoppish.ui.theme.metropolisFamilyFont
//import com.example.shoppish.project.MVVM.Screen
import com.example.shoppish.ui.theme.poppinsFamilyFont

@Composable
fun ForgotPass(navController: NavController,
               viewModel: AuthViewModel

) {
    var password = ""
    val outlinedTextField = remember{ mutableStateOf("") }
    val outlinedEmailField = remember{ mutableStateOf("") }
    val outlinedPassField = remember{ mutableStateOf("") }
    val textField = remember{ mutableStateOf("") }
    val passField = remember{ mutableStateOf("") }
    val emailField = remember{ mutableStateOf("") }

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
            text = viewModel.forgotText,
            modifier = Modifier.align(Alignment.CenterHorizontally),
            fontFamily = poppinsFamilyFont,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        )



        Spacer(modifier = Modifier.height(73.dp))
        // Spacing between content and button

        Text(text = viewModel.plzEnter,
            fontFamily = metropolisFamilyFont,
            fontSize = 14.sp,
            color = Color.Black,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(top =  3.dp))
        Spacer(modifier = Modifier.height(16.dp)) // Spacing between content and button

        OutlinedTextField(
            value = outlinedEmailField.value,
            onValueChange = { outlinedEmailField.value = it },
            label = {Text("Email")},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            modifier = Modifier.fillMaxWidth()
        )

        


        Spacer(modifier = Modifier.height(55.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape(25.dp),
            enabled = true,
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.orange),
//                contentColor = colorResource(id = R.color.white)
            ),
            onClick = { },
        )

        {
            Text(text = "SEND",
                style = TextStyle(
                    color = colorResource(id = R.color.white),
                    fontFamily = poppinsFamilyFont,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                ),
            )

        }



    }

}


//navController.navigate(Screen.Login.route)


@Preview(showBackground = true)
@Composable
fun ForgotPreview() {
    val navController = rememberNavController()
    ForgotPass(navController, viewModel())
}