package com.example.shoppish.project.Product


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.project.BottomSheets.BottomSizeSheet
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavProductList(product: FavProduct) {
    var favProduct by remember { mutableStateOf(false) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Box {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp)
                .height(104.dp)
                .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp))
                .background(Color.White)
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.favorites) ,
                    contentDescription = "",
                    modifier = Modifier.size(104.dp))

                Column(
                    modifier = Modifier.background(Color.White)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Start, // Aligns content to the start
                        verticalAlignment = Alignment.CenterVertically
                    ) {


                        Spacer(modifier = Modifier.width(8.dp))

                        Column (
                            modifier = Modifier
                                .fillMaxSize(),
//            verticalAlignment = Alignment.CenterVertically,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = product.company,
                                modifier = Modifier
                                    .padding(bottom = 2.dp, top = 12.dp)
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    color = Color(android.graphics.Color.GRAY),
                                    fontSize = 11.sp, // Change the font size here
                                    fontWeight = FontWeight.Light, // Change the font weight here
                                    fontFamily = metropolisFamilyFont,
                                    // Change the font family here
                                )
                            )
                            Text(
                                text = product.name,
                                modifier = Modifier
                                    .padding(bottom = 2.dp, top = 2.dp)
                                    .fillMaxWidth(),
                                style = TextStyle(
                                    color = Color(android.graphics.Color.BLACK),
                                    fontSize = 15.sp, // Change the font size here
                                    fontWeight = FontWeight.SemiBold, // Change the font weight here
                                    fontFamily = metropolisFamilyFont,
                                    // Change the font family here
                                )
                            )
                            Row {
                                Text(
                                    text = "Color: ",
                                    modifier = Modifier
                                        .padding(bottom = 3.dp, top = 4.dp),
                                    style = TextStyle(
                                        color = Color(0xFF9B9B9B),
                                        fontSize = 11.sp, // Change the font size here
                                        fontWeight = FontWeight.Light, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )
                                Text(
                                    text = "${product.color}",
                                    modifier = Modifier
                                        .padding(bottom = 3.dp, top = 4.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 11.sp, // Change the font size here
                                        fontWeight = FontWeight.Light, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )

                                Spacer(modifier = Modifier.width(25.dp))

                                Text(
                                    text = "Size: ",
                                    modifier = Modifier
                                        .padding(bottom = 3.dp, top = 4.dp),
                                    style = TextStyle(
                                        color = Color(0xFF9B9B9B),
                                        fontSize = 11.sp, // Change the font size here
                                        fontWeight = FontWeight.Light, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )
                                Text(
                                    text = "${product.size}",
                                    modifier = Modifier
                                        .padding(bottom = 3.dp, top = 4.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 11.sp, // Change the font size here
                                        fontWeight = FontWeight.Light, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )

                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(26.dp)
                                    .padding(top = 6.dp),

                                ) {
                                Text(
                                    text = "$${product.price}",
                                    modifier = Modifier
                                        .padding(top = 4.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 14.sp, // Change the font size here
                                        fontWeight = FontWeight.SemiBold, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )
                                Spacer(modifier = Modifier.width(54.dp))

                                RatingBar(rating = product.review.toDouble())



                                Text(
                                    text = "(${product.noOfReviews})",
                                    modifier = Modifier
                                        .padding(start = 3.dp, top = 7.dp),
                                    style = TextStyle(
                                        color = Color(0xFF9B9B9B),
                                        fontFamily = metropolisFamilyFont,
                                        fontWeight = FontWeight.Light,
                                        fontSize = 10.sp
                                    )
                                )


                            }

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


            }


        }

        FloatingActionButton(
            onClick = { favProduct = !favProduct
                isSheetOpen = true},
            modifier = Modifier
                .size(36.dp)
                .offset(x = (340.4).dp, y = (93).dp)
                .background(Color.Transparent, CircleShape),
            shape = CircleShape,
            containerColor = Color.White
        ) {
            Icon(
                painter = painterResource(id = if (favProduct) R.drawable.favselected else R.drawable.favunselected), // Change the icon based on favProduct
                contentDescription = "Favorite",
                modifier = Modifier
                    .padding(top = 1.dp)
                    .background(Color.White)
                ,

                tint = if (favProduct) Color(0xFFFF6347) else Color.Black
            )
        }
    }

}

data class FavProduct(
    val id: Int,
    val name: String,
    val company: String,
    val color: String,
    val discount: Int,
    val price: Double,
    val imageUrl: String,
    val review: Double,
    val size: String,
    val noOfReviews: Int// Default value for noOfReviews

)

@Composable
@Preview
fun FavProductListPreview() {
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