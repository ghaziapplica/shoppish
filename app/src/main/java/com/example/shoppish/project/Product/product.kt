package com.example.shoppish.project.Product

import android.graphics.Color.BLACK
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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.BottomSheets.BottomSizeSheet
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductItem(product: Product,
                navController: NavController,) {
    var favProduct by remember { mutableStateOf(false) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()


    Box {


    Card(
        modifier = Modifier
            .width(150.dp)
            .height(260.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(8.dp)
    ) {


        Box {


            Image(
                painter = painterResource(id = R.drawable.productdumy), // replace with your actual image resource
                contentDescription = "Product Image",
                modifier = Modifier
                    .size(164.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.White)
//                .padding(top = 3.dp)
            )

            Box(
                modifier = Modifier
                    .size(40.dp, 24.dp) // Set the size of the box here
                    .padding(top = 10.dp, start = 10.dp)
                    .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                    .background(Color(0xFFDB3022)), // Set the background color here

                // Set the background color here
                contentAlignment = Alignment.Center // Center the text within the box
            ) {
                Text(
                    text = "-${product.discount}%",
                    modifier = Modifier
                        .padding(top = 2.dp, start = 2.dp, bottom = 2.dp, end = 2.dp),
                    style = TextStyle(
                        fontSize = 6.sp, // Reduce the font size here
                        color = Color.White, // Change the font color here
                        fontWeight = FontWeight.SemiBold, // Change the font weight here
                        fontFamily = metropolisFamilyFont // Change the font family here
                    )
                )
                Button(
                    onClick = { /* Handle the button click here */ },
                    modifier = Modifier
                        .size(56.dp) // Set the size of the button here
                        .align(Alignment.BottomEnd) // Align the button to the bottom end (bottom right) corner
                        .padding(16.dp) // Add padding around the button
                        .zIndex(1f), // Make the button float above other items
                    colors = ButtonDefaults.buttonColors(Color.Red) // Set the button color here
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.heartclicked), // Replace with your actual favorite icon resource
                        contentDescription = "Favorite"
                    )
                }
            }

            // Display the discount percentage


        }

        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalArrangement = Arrangement.Start, // Aligns content to the start
            verticalAlignment = Alignment.CenterVertically
        ) {


            Spacer(modifier = Modifier.width(8.dp))

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White),
//            verticalAlignment = Alignment.CenterVertically,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)
                        .weight(1f),

                    ) {
                    RatingBar(rating = product.review.toDouble())



                    Text(
                        text = "(${product.noOfReviews})",
                        modifier = Modifier
                            .padding(start = 3.dp, top = 7.dp),
                        style = TextStyle(
                            color = Color(0xFF9B9B9B),
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Light,
                            fontSize = 8.sp
                        )
                    )


                }

                Text(
                    text = product.description,
                    modifier = Modifier
                        .padding(bottom = 3.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        color = Color(0xFF9B9B9B),
                        fontSize = 11.sp, // Change the font size here
                        fontWeight = FontWeight.Light, // Change the font weight here
                        fontFamily = metropolisFamilyFont,
                        // Change the font family here
                    )
                )
                Text(
                    text = product.name,
                    modifier = Modifier
                        .padding(bottom = 2.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        color = Color(BLACK),
                        fontSize = 15.sp, // Change the font size here
                        fontWeight = FontWeight.SemiBold, // Change the font weight here
                        fontFamily = metropolisFamilyFont,
                        // Change the font family here
                    )
                )


                val discountedPrice = product.price - (product.price * product.discount / 100)
                val priceText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Gray,
                            textDecoration = TextDecoration.LineThrough
                        )
                    ) {
                        append("$${product.price} ")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFFDB3022))) { // Color(0xFFFFA500) is orange
                        append("$${discountedPrice}")
                    }
                }
                Text(
                    text = priceText,
                    modifier = Modifier
                        .padding(bottom = 5.dp)
                        .fillMaxWidth(),
                    style = TextStyle(
                        fontSize = 13.sp, // Change the font size here
                        fontWeight = FontWeight.Normal, // Change the font weight here
                        fontFamily = metropolisFamilyFont,
                        // Change the font family here

                    )
                )
            }
            if(isSheetOpen){
                ModalBottomSheet(
                    sheetState = sheetState ,
                    onDismissRequest = { isSheetOpen = false }
                ) {
                    Box(modifier = Modifier.background(Color.White)) {
                        BottomSizeSheet()
                    }
                }
            }


        }


    }
        FloatingActionButton(
            onClick = { favProduct = !favProduct
                        isSheetOpen = true},
            modifier = Modifier
                .size(36.dp)
                .offset(x = (110).dp, y = (150).dp)
                .background(Color.Transparent, CircleShape),
            shape = CircleShape,
            containerColor = Color.White
        ) {
            Icon(
                painter = painterResource(id = if (favProduct) R.drawable.favselected else R.drawable.favunselected), // Change the icon based on favProduct
                contentDescription = "Favorite",
                modifier = Modifier.padding(top = 1.dp)
                    .background(Color.White)
                ,

                tint = if (favProduct) Color(0xFFFF6347) else Color.Black
            )
        }
}

}

@Composable
fun RatingBar(rating: Double, max: Int = 5) {
    Row {
        for (i in 1..max) {
            val image = when {
                i <= rating.toInt() -> R.drawable.full_star
                i - 1 < rating -> R.drawable.star_half
                else -> R.drawable.star_empty
            }
            Box(
                modifier = Modifier.width(15.dp), // Adjust this value to control the distance between the stars
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = "Star",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

data class Product(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrl: String,
    val review: Double,
    val discount: Int,
    val noOfReviews: Int// Default value for noOfReviews

)



@Composable
@Preview
fun ProductItemPreview() {
    ProductItem(
        product = Product(
            id = 1,
            name = "Evening Dress",
            description = "Dorothy Perkins",
            price = 3.5,
            imageUrl = "",
            review = 4.5,
            discount = 40,
            noOfReviews = 10
        ),
        rememberNavController(),
    )

}
