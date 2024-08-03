package com.example.shoppish.project.BottomSheets


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordSheet(){
    var textFieldValue by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .background(Color(0xFFF9F9F9))
    ) {


        Column (
            modifier = Modifier
                .fillMaxWidth()
                .height(375.dp)
                .padding(16.dp)
                .background(Color(0xFFF9F9F9))
        ){
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Select Size",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                )
            }
            Spacer(modifier = Modifier.height(21.dp))

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { newValue -> textFieldValue = newValue },
                label = { Text("Password",
                    fontFamily = metropolisFamilyFont,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Set your desired color for focused state
                    unfocusedBorderColor = Color(0xFFF9F8F8),
                    containerColor = Color.White // Set your desired color for unfocused state
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End) {
                Text(
                    text = "Forgot Password",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(21.dp))

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { newValue -> textFieldValue = newValue },
                label = { Text("Password",
                    fontFamily = metropolisFamilyFont,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Set your desired color for focused state
                    unfocusedBorderColor = Color(0xFFF9F8F8),
                    containerColor = Color.White  // Set your desired color for unfocused state
                )
            )
            Spacer(modifier = Modifier.height(21.dp))

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { newValue -> textFieldValue = newValue },
                label = { Text("Password",
                    fontFamily = metropolisFamilyFont,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Medium) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Gray, // Set your desired color for focused state
                    unfocusedBorderColor = Color(0xFFF9F8F8),
                    containerColor = Color.White  // Set your desired color for unfocused state
                )
            )


        }
        TabRowDefaults.Divider(
            color = Color.LightGray,
            thickness = 0.4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp, bottom = 28.dp),
            horizontalArrangement = Arrangement.Center

        ){
            androidx.compose.material.Button(
                onClick = { },
                modifier = Modifier
                    .size(width = 343.dp, height = 48.dp),
                shape = RoundedCornerShape(26.dp),
                colors = androidx.compose.material.ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        0xFFDB3022
                    )
                ) // Use the orange color
            ) {
                Text(
                    text = "SAVE PASSWORD",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = metropolisFamilyFont
                )
            }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun PasswordSheetPreview() {
    PasswordSheet()
}