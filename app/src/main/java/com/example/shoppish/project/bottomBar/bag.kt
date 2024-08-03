package com.example.shoppish.project.bottomBar

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.project.BottomSheets.PromoCodeSheet
import com.example.shoppish.project.Product.BagProduct
import com.example.shoppish.project.Product.BagProductList
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BagScreen( navController: NavController,){
    val searchQuery = remember { mutableStateOf("") }
    var price by remember { mutableIntStateOf(124) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                PromoCodeSheet()
            }
        }
    }

//    val product = FavProduct(
//        id = 1,
//        name = "Shirt",
//        company = "Dorothy Perkins",
//        price = 4.5,
//        color = "Blue",
//        imageUrl = "",
//        review = 3.0,
//        size = "XL",
//        noOfReviews = 10,
//        discount = 40
//    )

    Box(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.End,
            ){
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.Black,
                    modifier = Modifier.size(36.dp)
                        .clickable { navController.navigate(BagsScreen.Red.route) }
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.Start,
            ){
                Text(
                    text = "My Bag",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Box(
                modifier = Modifier.height(410.dp)
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize()
                ) {
                    items(20) {
                        Box(

                        )
                        {
                            BagProductList( product = BagProduct(
                                id = 1,
                                name = "Shirt",
                                price = 4.5,
                                color = "Blue",
                                imageUrl = "",
                                size = "XL",
                            ),
                                onQuantityChange = { })
                        }

                    }

                }
            }
            Spacer(modifier = Modifier.height(20.dp))
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
                    Text(
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
                    onClick = { isSheetOpen = true },
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween


            ){
                Text(
                    text = "Total Amount:",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize =  14.sp),
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                )
                Text(
                    text = "$$price",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize =  18.sp),
                    color = Color.Black,
                    modifier = Modifier
                        .padding(start = 10.dp, top = 10.dp)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(bottom = 10.dp),
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Button(
                        onClick = {
                            navController.navigate(BagsScreen.Red.route)},
                        modifier = Modifier
                            .size(width = 343.dp, height = 48.dp)
                            .padding(end = 13.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDB3022)) // Use the orange color
                    ) {
                        Text(
                            text = "CHECK OUT",
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
@Preview(showBackground = true)
fun BagScreenPreview(){
    BagScreen( navController = rememberNavController())
}
