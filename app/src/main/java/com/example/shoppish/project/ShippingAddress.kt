package com.example.shoppish.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShippingAddressesPreview( navController: NavController) {
    val namesAddresses = listOf(
        Pair("John Doe", "123 Main St"),
        Pair("Jane Doe", "3 Newbridge Court \n" +
                "Chino Hills, CA 91709, United States") ,
        Pair("Jane Doe", "Suite 742 14317 Kris Garden, \n" +
                "Murrayside, IL 53461-9709")
        // Add more pairs as neededSuite 742 14317 Kris Garden, Murrayside, IL 53461-9709
    )


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
                            text = "Shipping Addresses", color = Color.Black,
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
//            colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.White)
            )

            Spacer(modifier = Modifier.height(24.dp))


            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(namesAddresses) { nameAddress ->
                    ShippingAddressBox(
                        name = nameAddress.first,
                        address = nameAddress.second,

                        )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

        }
        Box(
            modifier = Modifier
                .size(75.dp)
                .align(Alignment.BottomEnd)
        ) {
            FloatingActionButton(
                onClick = { navController.navigate(BagsScreen.Address.route)  },
                modifier = Modifier
                    .size(36.dp)
                    .align(Alignment.Center)// Align FAB to the right
                    .padding(), // Add padding to the end
                containerColor = Color.Black,
            ) {
                Icon(
                    Icons.Filled.Add,
                    contentDescription = "Search",
                    tint = Color.White)
            }
        }
    }
}



@Composable
fun ShippingAddressBox(name: String, address: String) {
    val isChecked = remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .width(343.dp)
            .height(150.dp)
            .shadow(1.dp)
    ) {
        Column {
            Row {
                Text(
                    text = name, color = Color.Black,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp, start = 28.dp)
                )
                Text(
                    text = "Edit",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        color = Color(0xFFDB3022),
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp, start = 200.dp)
                )
            }

            Text(
                text = address, color = Color.Black,
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.Normal,
                    lineHeight = 25.sp,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(start = 28.dp, top = 16.dp)
            )
            // Additional content can be added here
            Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, start = 28.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .padding(bottom = 5.dp)
            ) {
                Checkbox(
                    checked = isChecked.value,
                    onCheckedChange = { isChecked.value = it }
                )
            }

            Text(
                text = "Use as the shipping address",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(start = 13.dp, top = 5.dp)
            )
        }

        }
    }
}

@Composable
@Preview(showBackground = true)
fun ShippingAddressPreview() {
    ShippingAddressesPreview(  navController = rememberNavController())
}



//
//Box(
//modifier = Modifier
//.clip(RoundedCornerShape(10.dp))
//.background(Color.White)
//.width(343.dp)
//.height(150.dp)
//) {
//    Column {
//        Row {
//            Text(
//                text = name, color = Color.Black,
//                style = TextStyle(
//                    fontFamily = metropolisFamilyFont,
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 14.sp
//                ),
//                modifier = Modifier.padding(top = 18.dp, start = 28.dp)
//            )
//            Text(
//                text = "Edit",
//                style = TextStyle(
//                    fontFamily = metropolisFamilyFont,
//                    color = Color(0xFFDB3022),
//                    fontWeight = FontWeight.SemiBold,
//                    fontSize = 14.sp
//                ),
//                modifier = Modifier.padding(top = 18.dp, start = 200.dp)
//            )
//        }
//
//        Text(
//            text = address, color = Color.Black,
//            style = TextStyle(
//                fontFamily = metropolisFamilyFont,
//                fontWeight = FontWeight.Normal,
//                lineHeight = 25.sp,
//                fontSize = 14.sp
//            ),
//            modifier = Modifier.padding(start = 28.dp, top = 16.dp)
//        )
//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 20.dp, start = 28.dp),
//        ) {
//            Box(
//                modifier = Modifier
//                    .size(30.dp)
//                    .padding(bottom = 5.dp)
//            ) {
//                Checkbox(
//                    checked = isTickCheckedState.value,
//                    onCheckedChange = { newValue -> isTickCheckedState.value = newValue }
//                )
//            }
//
//            Text(
//                text = "Use as the shipping address",
//                fontFamily = metropolisFamilyFont,
//                fontSize = 14.sp,
//                color = Color.Black,
//                fontWeight = FontWeight.Medium,
//                modifier = Modifier.padding(start = 13.dp, top = 5.dp)
//            )
//        }
//    }
//}