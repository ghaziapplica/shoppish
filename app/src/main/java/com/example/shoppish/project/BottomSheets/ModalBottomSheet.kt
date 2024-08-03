package com.example.shoppish.project.BottomSheets

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.ui.theme.metropolisFamilyFont

@Composable
fun ModalBottomSizeSheet(){
    val selectedButton4 = remember { mutableStateOf(-1) }
    val category = listOf("All","Woman", "Men")
    val category2 = listOf("Boys", "Girls")
    val selectedButton3 = remember { mutableStateOf(-1) } // Add this line at the beginning of your Composable


    Column {


        Column (
            modifier = Modifier
                .fillMaxWidth()     
                .height(200.dp)
                .background(Color.White)
        ){
            Column(
                modifier = Modifier.fillMaxWidth()
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

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, start = 18.dp, end = 18.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                category.forEachIndexed{ category, size ->
                    Button(
                        onClick = { selectedButton3.value = category },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(width = 100.dp, height = 50.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFF9B9B9B),
                                RoundedCornerShape(10.dp)
                            ),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedButton3.value == category) Color(
                                0xFFDB3022
                            ) else Color.White, // Change the background color if this button is selected
                        ), // Use the orange color'
//                            shape = RectangleShape,
                        contentPadding = PaddingValues(start = 15.dp)
                    ) {
                        Text(
                            text = size,
                            color = if (selectedButton3.value == category) Color.White else Color.Black,
                            fontSize = 16.sp,
                            fontFamily = metropolisFamilyFont,
                            modifier = Modifier.fillMaxWidth()


                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 12.dp, start = 18.dp, end = 18.dp),
                horizontalArrangement = Arrangement.Start,
            ) {
                category2.forEachIndexed{ category2, size ->
                    Button(
                        onClick = { selectedButton4.value = category2 },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier
                            .size(width = 115.dp, height = 50.dp)
                            .padding(start = 14.dp)
                            .border(
                                width = 1.dp,
                                color = Color(0xFF9B9B9B),
                                RoundedCornerShape(10.dp)
                            ),

                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedButton4.value == category2) Color(
                                0xFFDB3022
                            ) else Color.White, // Change the background color if this button is selected
                        ), // Use the orange color'
//                            shape = RectangleShape,
                        contentPadding = PaddingValues(start = 15.dp)
                    ) {
                        Text(
                            text = size,
                            color = if (selectedButton4.value == category2) Color.White else Color.Black,
                            fontSize = 16.sp,
                            fontFamily = metropolisFamilyFont,
                            modifier = Modifier.fillMaxWidth()


                        )
                    }
                }
            }
        }
        TabRowDefaults.Divider(
            color = Color.LightGray,
            thickness = 0.4.dp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Size Info",
                fontFamily = metropolisFamilyFont,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(start = 18.dp, top = 16.dp, bottom = 16.dp),
                style = TextStyle(letterSpacing = 1.sp)
            )

            Icon(imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "Dropdown arrow",
                modifier = Modifier.padding(end = 18.dp) )

        }
        TabRowDefaults.Divider(
            color = Color.LightGray,
            thickness = 0.4.dp,
            modifier = Modifier.fillMaxWidth()
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
            text = "ADD TO CART",
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
fun ModalBottomSheetPreview(){
    ModalBottomSizeSheet()
}