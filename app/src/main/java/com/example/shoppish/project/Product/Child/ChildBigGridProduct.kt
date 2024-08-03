package com.example.shoppish.project.Product.Child



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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.shoppish.R
import com.example.shoppish.project.BottomSheets.BottomSizeSheet
import com.example.shoppish.project.Product.RatingBar
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildBigGridProduct(
    product: ChildProduct,
    imageUrl: String) {
    val customFont = FontFamily(Font(resId = R.font.metropolis_black))
    var favProduct by remember { mutableStateOf(false) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    Box {


        Card(
            modifier = Modifier
                .width(164.dp)
                .height(291.dp)
                .padding(8.dp)
                .clickable { },

            shape = RoundedCornerShape(8.dp)
        ) {


            Box {


                Image(
                    painter = painterResource(id =  imageUrl.toInt()), // replace with your actual image resource
                    contentDescription = "Product Image",
                    modifier = Modifier
                        .height(175.dp)
                        .width(164.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    alignment = Alignment.TopCenter
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
                    .padding(),
                horizontalArrangement = Arrangement.Start, // Aligns content to the start
                verticalAlignment = Alignment.CenterVertically
            ) {


                Spacer(modifier = Modifier.width(8.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
//            verticalAlignment = Alignment.CenterVertically,
                    horizontalAlignment = Alignment.Start
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(bottom = 0.dp),

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
                            .padding(bottom = 4.dp)
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
                            .padding(bottom = 1.dp)
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
                            text = "${product.id}",
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
                            text = "${product.discount}",
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
                    Spacer(modifier = Modifier.height(4.dp))



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
    FloatingActionButton(
        onClick = { favProduct = !favProduct
            isSheetOpen = true},
        modifier = Modifier
            .size(36.dp)
            .offset(x = (120).dp, y = (145).dp)
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



@Composable
@Preview
fun FavProductGridPreview(){
    ChildBigGridProduct(
        product = ChildProduct(
            id = 1,
            name = "Evening Dress",
            description = "Dorothy Perkins",
            price = 4.5,
            imageUrlGrid = "",
            imageUrlGridBig = "",
            imageUrlList = "",
            review = 3.0,
            discount = 40,
            noOfReviews = 10
        ),
        imageUrl = ""
    )
}