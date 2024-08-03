@file:JvmName("CheckoutKt")

package com.example.shoppish.project
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Checkout (navController: NavController){

    val name = "John Doe"
    val address = "3 Newbridge Court \n" +
            "Chino Hills, CA 91709, United States"
    val cardNo  = 2235
    val order  = 112
    val delivery  = 15
    val summary  = order + delivery
//    var showShadow by remember { mutableStateOf(false) }
//    val boxModifier = if (showShadow) {
////        Modifier.shadow(4.dp, RoundedCornerShape(10.dp))
//    } else {
////        Modifier.shadow(1.dp, RoundedCornerShape(4.dp))
//    }
    Column {


        TopAppBar(
            modifier = Modifier.height(80.dp)
                .background(Color.White),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Categories", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize =  21.sp),
                        modifier = Modifier.padding(top = 25.dp)
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back button click here */ },
                    modifier = Modifier.padding(top = 10.dp)) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            },
            actions = {
                IconButton(onClick = {  },
                    modifier = Modifier.padding(top = 10.dp)) {
                    Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.Black)
                }
            },
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9)),
        ) {
            Row (
                modifier = Modifier.fillMaxWidth()
            ){
                Text(
                    text = "Shipping Address",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize =  16.sp),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                )

            }

            Box (
                modifier = Modifier

                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 20.dp, bottom = 16.dp)
                    .height(108.dp)
                    .shadow(elevation = 3.dp, shape = RoundedCornerShape(16.dp))
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)



            ){
                Row(
                    modifier = Modifier
                        .padding(top = 18.dp)
                ) {
                    Column {
                        Row {
                            Text(text = name,
                                style = TextStyle(
                                    fontFamily = metropolisFamilyFont,
                                    fontWeight = FontWeight.Normal,
                                    fontSize =  16.sp),
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 10.dp, top = 10.dp)

                            )

                        }
                        Row {
                            Text(text = address,
                                style = TextStyle(
                                    fontFamily = metropolisFamilyFont,
                                    fontWeight = FontWeight.Normal,
                                    fontSize =  16.sp),
                                color = Color.DarkGray,
                                modifier = Modifier
                                    .padding(start = 10.dp, top = 10.dp)

                            )

                        }
                    }
                    Column {
                        Text(text = "Change",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            color = (Color(0xFFFF6347)),
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                                .clickable { navController.navigate(BagsScreen.Shipping.route) }

                        )
                    }

                }

            }

            Box(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 56.dp, bottom = 16.dp)
                    .fillMaxWidth()
            ) {
                Row {
                    Column {
                        Row {
                            Text(text = "Payment",
                                style = TextStyle(
                                    fontFamily = metropolisFamilyFont,
                                    fontWeight = FontWeight.SemiBold,
                                    fontSize =  16.sp),
                                color = Color.Black,
                                modifier = Modifier
                                    .padding(start = 10.dp, top = 10.dp)

                            )
                        }
                        Row {
                            Column {
                                Image(
                                    painter = painterResource(id = R.drawable.mastercard) ,
                                    contentDescription = "",
                                    modifier = Modifier
                                        .width(100.dp)
                                        .height(90.dp),)
                            }
                            Column {
                                Text(text = "**** **** **** $cardNo",
                                    style = TextStyle(
                                        fontFamily = metropolisFamilyFont,
                                        fontWeight = FontWeight.Normal,
                                        fontSize =  16.sp),
                                    color = Color.Black,
                                    modifier = Modifier
                                        .padding(start = 10.dp, top = 30.dp)

                                )
                            }

                        }
                    }
                    Column {
                        Text(text = "Change",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            color = (Color(0xFFFF6347)),
                            modifier = Modifier
                                .padding(start = 54.dp, top = 10.dp)
                                .clickable {  navController.navigate(BagsScreen.Payment .route) }

                        )

                    }
                }
            }

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                Column {
                    Row {
                        Text(text = "Delivery method",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp))


                    }
                    Row {
                        Box(
                            modifier = Modifier
                                  // Apply conditional shadow
                                .clickable {}
                        ) {
                            Image(painter = painterResource(id = R.drawable.fedex),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp))


                        }
                        Box (
                            modifier = Modifier
//                                .then(boxModifier) // Apply conditional shadow
                                .clickable { }
                        ){
                            Image(painter = painterResource(id = R.drawable.usps),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp))
                        }
                        Box (
                            modifier = Modifier
//                                .then(boxModifier) // Apply conditional shadow
                                .clickable { }
                        ) {
                            Image(painter = painterResource(id = R.drawable.dhl),
                                contentDescription = null,
                                modifier = Modifier.size(120.dp))
                        }

                    }
                }
            }

            Box {
                Column(
                    modifier = Modifier.padding(start = 19.dp, end = 19.dp, top = 10.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Order:",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  14.sp),
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )

                        Text(text = "$$order",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  14.sp),
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Delivery:",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  14.sp),
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )

                        Text(text = "$$delivery",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  14.sp),
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )
                    }
                    Row (
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(text = "Summary:",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            color = Color.Gray,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )
                        Text(text = "$$summary",
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            color = Color.Black,
                            modifier = Modifier
                                .padding(start = 10.dp, top = 10.dp)
                        )

                    }
                }
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
                        onClick = {navController.navigate(BagsScreen.Success.route)},
                        modifier = Modifier
                            .size(width = 343.dp, height = 48.dp)
                            .padding(end = 10.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                    ) {
                        Text(
                            text = "SUBMIT ORDER",
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
fun CheckoutPreview(){
    Checkout( navController = rememberNavController())
}
