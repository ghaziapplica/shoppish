package com.example.shoppish.project.BottomSheets

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.ui.theme.metropolisFamilyFont

@Composable
fun  PromoCodeSheet(){
    val promoCode1: String = "PROMO123"
    val promoCode2: String = "PROMO43f"
    val promoCode3: String = "AD34CR43"

    val promoCodeName1: String = "Summer Sale"
    val promoCodeName2: String = "Winter Sale"
    val promoCodeName3: String = "Eid Sale"

    val promoCodePercentage1: Int = 15
    val promoCodePercentage2: Int = 25
    val promoCodePercentage3: Int = 40

    val promoCodeCountdown1: Int = 22
    val promoCodeCountdown2: Int = 12
    val promoCodeCountdown3: Int = 2
    val searchQuery = remember { mutableStateOf("") }



    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(470.dp)
            .padding(start = 16.dp, end = 16.dp,)
    ){
        Column {
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .size(width = 344.dp, height = 40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .padding(top = 0.dp)
                    .background(Color.White)
            ) {
                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(start = 10.dp, top = 10.dp, end = 56.dp), // Adjust padding to make space for the FAB
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp,
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                if (searchQuery.value.isEmpty()) {
                    androidx.compose.material.Text(
                        text = "Enter your promo code",
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize =  16.sp),
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 40.dp)
                    )
                }
                FloatingActionButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(36.dp)
                        .align(Alignment.CenterEnd) // Align FAB to the right
                        .padding(end = 0.dp), // Add padding to the end
                    containerColor = Color.Black,
                ) {
                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "Search",
                        tint = Color.White)
                }
            }
            Spacer(modifier = Modifier.height(14.dp))
            Text(text = "Your Promo Codes",
                fontFamily = metropolisFamilyFont,
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
                style = TextStyle(letterSpacing = 1.sp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(13.dp))
            ) {

                Box (
                    modifier = Modifier
                        .width(80.dp)
                        .fillMaxHeight()
                        .background(Color(0xFFDB3022))
                ) {
                    Row (
                        modifier = Modifier.padding(top = 25.dp, start = 10.dp)
                    ){


                        Column {
                            Text(
                                text = "$promoCodePercentage1",
                                fontFamily = metropolisFamilyFont,
                                fontSize = 34.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                style = TextStyle(letterSpacing = 1.sp)
                            )
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                        Column {
                            Column {
                                Text(
                                    text = "%",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                                Text(
                                    text = "off",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }

                        }
                    }

                }
                Box (){
                    Row(
                        modifier = Modifier.fillMaxSize()
                            .padding (end = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column(
                            modifier = Modifier.padding(start = 14.dp, top = 22.dp)
                        ) {
                            Row {
                                Text(text = promoCodeName1,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                Text(text = promoCode1,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                        }
                        Column (
                            modifier = Modifier.padding(top = 12.dp, start = 36.dp)
                        ){
                            Row {
                                Text(text = "$promoCodeCountdown1 days remaining",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                            Row(
                                modifier = Modifier.padding(start = 16.dp)
                            ) {
                                Button(
                                    onClick = {  },
                                    modifier = Modifier
                                        .size(width = 93.dp, height = 40.dp)
                                        .padding(top = 10.dp),
                                    shape = RoundedCornerShape(26.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                                ) {
                                    Text(
                                        text = "Apply",
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
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(13.dp))
            ) {

                Box (
                    modifier = Modifier
                        .width(80.dp)
                        .fillMaxHeight()
                ){
                    Image(
                        painter = painterResource(id = R.drawable.summersales) ,
                        contentDescription = "",
                        modifier = Modifier.size(104.dp))
                    Row (
                        modifier = Modifier.padding(top = 25.dp, start = 10.dp)
                    ){


                        Column {
                            Text(
                                text = "$promoCodePercentage2",
                                fontFamily = metropolisFamilyFont,
                                fontSize = 34.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.ExtraBold,
                                style = TextStyle(letterSpacing = 1.sp)
                            )
                        }
                        Spacer(modifier = Modifier.width(2.dp))
                        Column {
                            Column {
                                Text(
                                    text = "%",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                                Text(
                                    text = "off",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }

                        }
                    }

                }
                Box (){
                    Row(
                        modifier = Modifier.fillMaxSize()
                            .padding(end = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween

                    ) {
                        Column(
                            modifier = Modifier.padding(start = 14.dp, top = 22.dp)
                        ) {
                            Row {
                                Text(text = promoCodeName2,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                Text(text = promoCode2,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                        }
                        Column (
                            modifier = Modifier.padding(top = 12.dp, start = 36.dp)
                        ){
                            Row {
                                Text(text = "$promoCodeCountdown2 days remaining",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                            Row(
                                modifier = Modifier.padding(start = 14.dp)
                            ) {
                                Button(
                                    onClick = {  },
                                    modifier = Modifier
                                        .size(width = 93.dp, height = 40.dp)
                                        .padding(top = 10.dp),
                                    shape = RoundedCornerShape(26.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                                ) {
                                    Text(
                                        text = "Apply",
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
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .clip(RoundedCornerShape(13.dp))
            ) {

                Box (
                    modifier = Modifier
                        .width(80.dp)
                        .fillMaxHeight()
                        .background(Color.Black)

                ){
                    Row (
                        modifier = Modifier.padding(top = 25.dp, start = 10.dp)
                    ){


                        Column {
                            Text(
                                text = "$promoCodePercentage3",
                                fontFamily = metropolisFamilyFont,
                                fontSize = 34.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold,
                                style = TextStyle(letterSpacing = 0.sp)
                            )
                        }
                        Spacer(modifier = Modifier.width(1.dp))
                        Column {
                            Column {
                                Text(
                                    text = "%",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                                Text(
                                    text = "off",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }

                        }
                    }

                }
                Box (){
                    Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column(
                            modifier = Modifier.padding(start = 14.dp, top = 22.dp)
                        ) {
                            Row {
                                Text(text = promoCodeName3,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 14.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.SemiBold,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )
                            }
                            Row(
                                modifier = Modifier.padding(top = 4.dp)
                            ) {
                                Text(text = promoCode3,
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Black,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                        }
                        Column (
                            modifier = Modifier.padding(top = 12.dp, start = 36.dp, end = 14.dp)
                        ){
                            Row {
                                Text(text = "$promoCodeCountdown3 days remaining",
                                    fontFamily = metropolisFamilyFont,
                                    fontSize = 11.sp,
                                    color = Color.Gray,
                                    fontWeight = FontWeight.Normal,
                                    style = TextStyle(letterSpacing = 1.sp)
                                )

                            }
                            Row (
                                modifier = Modifier.padding(start = 10.dp)
                            ){
                                Button(
                                    onClick = {  },
                                    modifier = Modifier
                                        .size(width = 93.dp, height = 40.dp)
                                        .padding(top = 10.dp),
                                    shape = RoundedCornerShape(26.dp),
                                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                                ) {
                                    Text(
                                        text = "Apply",
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
        }

    }
}

@Composable
@Preview(showBackground = true)
fun PromoCodeSheetPreview(){
    PromoCodeSheet()
}