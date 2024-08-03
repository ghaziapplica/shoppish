package com.example.shoppish.project

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
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
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddingAddress () {


    Box {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9)),
        ) {


            TopAppBar(
                modifier = Modifier
                    .height(80.dp)
                    .background(Color.White),
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Adding Address", color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 21.sp
                            ),
                            modifier = Modifier.padding(top = 25.dp)
                        )
                    }
                },
                navigationIcon = {
                    IconButton(
                        onClick = { /* Handle back button click here */ },
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                    }
                },
                actions = {
                    IconButton(
                        onClick = { },
                        modifier = Modifier.padding(top = 10.dp)
                    ) {
                        Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.Black)
                    }
                },
            )
            var textFieldValue by remember { mutableStateOf("") }

            Column(
                modifier = Modifier.width(343.dp)
                    .align( Alignment.CenterHorizontally)
            ) {
                Spacer(modifier = Modifier.padding(top = 40.dp));


                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("Full name",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("Address",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("City",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("State/Province/Region",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("Zip Code (Postal Code)",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = { newValue -> textFieldValue = newValue },
                    label = { Text("Country",
                        fontFamily = metropolisFamilyFont,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        fontWeight = FontWeight.Medium) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Color.Gray, // Set your desired color for focused state
                        unfocusedBorderColor = Color(0xFFF9F8F8),
                        containerColor = Color(0xFFFEFFFE) // Set your desired color for unfocused state
                    )
                )
                Spacer(modifier = Modifier.padding(top = 20.dp));

            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(bottom = 0.dp, top = 23.dp),
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .size(width = 343.dp, height = 48.dp)
                            .padding(end = 10.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                    ) {
                        Text(
                            text = "SAVE ADDRESS",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = metropolisFamilyFont
                        )
                    }

                }

            }



        }

    }
}

@Composable
@Preview
fun AddingAddressPreview() {
    AddingAddress()
}