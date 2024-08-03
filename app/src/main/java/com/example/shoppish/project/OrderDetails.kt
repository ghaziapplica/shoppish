package com.example.shoppish.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.project.Product.BagProduct
import com.example.shoppish.project.Product.BagProductList
import com.example.shoppish.project.Product.FavProduct
import com.example.shoppish.project.Product.FavProductList
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetails() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    scrolledContainerColor = Color.White,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        "Centered Top App Bar",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Localized description"
                                )
                            }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        OrderDetailContent(innerPadding)
    }

}

@Composable
fun OrderDetailContent(innerPadding: PaddingValues) {
    val scrollState = rememberScrollState()
    var orderNo = 178369
    var date = "12-12-2021"
    var trackingNo = "IW3475453455"
    var order = orderNo.toString()
    var quantity = 3
    val address = "1234 Main St, Anytown, USA"
    val cardNo = 5530610075300110
    val formattedCardNo = cardNo.toString()
        .replaceRange(0, 12, "************")
        .chunked(4).joinToString(" ")
    val image1 = R.drawable.mastercard // Replace 'image1' with your actual drawable resource name
    val image2 = R.drawable.visa // Replace 'image2' with your actual drawable resource name
    val deliveryCompany = "FedEx"
    val days = 5
    val amount = 150
    val discount = 20
    val totalAmount = amount - (amount * discount / 100)


    fun getCardImageResource(): Int {
        val firstDigit = cardNo.toString().first()
        return when (firstDigit) {
            '5' -> R.drawable.master
            '3' -> R.drawable.visa
            else -> R.drawable.default_card // Replace with your default image resource
        }
    }




    Box(
    modifier = Modifier
        .fillMaxSize()
        .padding(innerPadding)

        .background(Color(0xFFF9F9F9)),
) {
    Column {



        Column(modifier = Modifier.verticalScroll(scrollState)) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "Order №$order", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 18.dp)
                    )
                    Text(
                        text = date, color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 18.dp, start = 28.dp)
                    )
                }
                Row(
                    modifier = Modifier.padding()
                ) {
                    Text(
                        text = "Tracking number:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 18.dp)
                    )
                    Text(
                        text = trackingNo, color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 18.dp, start = 10.dp)
                    )
                    Text(
                        text = "Delivered", color = Color(0xFF2AA952),
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 18.dp, start = 62.dp)
                    )
                }
                Text(
                    text = "$quantity items", color = Color.Black,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp)
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
                            FavProductList( product = FavProduct(
                                id = 1,
                                name = "Shirt",
                                company = "Dorothy Perkins",
                                price = 4.5,
                                color = "Blue",
                                imageUrl = "",
                                review = 3.0,
                                size = "XL",
                                noOfReviews = 10,
                                discount = 40
                            )

                            )
                        }

                    }

                }
            }

            Text(
                text =   "Order information", color = Color.Black,
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(top = 8.dp, start = 16.dp )
            )

            Column (
                modifier = Modifier.padding(16.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text =   "Shipping Address:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                    Text(
                        text =   address, color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, start = 10.dp )
                    )

                }
                Spacer(modifier = Modifier.height(24.dp))
                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 3.dp)
                ){
                    Text(
                        text =   "Payment method:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 12.dp, )
                    )
                    Image(
                        painter = painterResource(id = getCardImageResource()),
                        contentDescription = "Card Image",
                        modifier = Modifier
                            .size(38.dp)
                            .padding(start = 12.dp)
                    )
                    Text(
                        text =   formattedCardNo, color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 12.dp, )
                    )

                }
                Spacer(modifier = Modifier.height(24.dp))
                Row (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text =   "Delivery method:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                    Text(
                        text =   deliveryCompany, color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp,start = 17.dp )
                    )
                    Text(
                        text =   ", $days days,", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                    Text(
                        text =   "$totalAmount$", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text =   "Discount:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                    Text(
                        text =   "$discount%, Personal promo code", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, start = 69.dp)
                    )

                }
                Spacer(modifier = Modifier.height(24.dp))
                Row (
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(
                        text =   "Total Amount:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp, )
                    )
                    Text(
                        text =   "$totalAmount$", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 8.dp,start = 36.dp )
                    )

                }

            }
            Spacer(modifier = Modifier.height(24.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(17.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .height(36.dp)
                        .width(160.dp)
                        .height(38.dp),
                    shape = RoundedCornerShape(20.dp), // Set the corner shape to 10.dp rounded
                    border = BorderStroke(1.dp, Color.Black), // Set the border to 1.dp black
                ) {
                    Text(text = "Details", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                    )
                }
                Button(
                    onClick = {  },
                    modifier = Modifier
                        .size(width = 160.dp, height = 38.dp)
                        .padding(end = 13.dp),
                    shape = RoundedCornerShape(26.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6347)) // Use the orange color
                ) {
                    Text(
                        text = "Discard",
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
fun OrderDetailsPreview() {
    OrderDetails()
}