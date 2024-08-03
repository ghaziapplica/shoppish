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
fun BagProductList(product: BagProduct,  onQuantityChange: (Int) -> Unit) {
    var favProduct by remember { mutableStateOf(false) }
    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    var itemNo by remember { mutableStateOf(1) }

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
                    painter = painterResource(id = R.drawable.bagpro) ,
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
                                text = product.name,
                                modifier = Modifier
                                    .padding(bottom = 2.dp, top = 8.dp)
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
                                    .padding(top = 6.dp),

                                ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Center
                                ) {
                                    // Minus Button
                                    FloatingActionButton(
                                        onClick = { if (itemNo > 0) itemNo -= 1 },
                                        modifier = Modifier
                                            .size(36.dp)
                                            .background(Color.Transparent, CircleShape),
                                        shape = CircleShape,
                                        containerColor = Color.White
                                    ) {
                                        Text("-", fontSize = 18.sp,
                                            color = Color.Black)
                                    }

                                    Spacer(modifier = Modifier.width(16.dp))

                                    // Display the current quantity
                                    Text(text = "${itemNo}", fontSize = 18.sp,
                                        color = Color.Black)

                                    Spacer(modifier = Modifier.width(16.dp))

                                    // Plus Button
                                    FloatingActionButton(
                                        onClick = { itemNo += 1 },
                                        modifier = Modifier
                                            .size(36.dp)
                                            .background(Color.White),
                                        containerColor = Color.White
                                    ) {
                                        Text("+", fontSize = 18.sp,
                                            color = Color.Black)
                                    }
                                }
                                Text(
                                    text = "$${product.price}",
                                    modifier = Modifier
                                        .padding(top = 10.dp, start = 86.dp),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontSize = 16.sp, // Change the font size here
                                        fontWeight = FontWeight.Normal, // Change the font weight here
                                        fontFamily = metropolisFamilyFont,
                                        // Change the font family here
                                    )
                                )
                                Spacer(modifier = Modifier.width(54.dp))




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

data class BagProduct(
    val id: Int,
    val name: String,
    val color: String,
    val price: Double,
    val imageUrl: String,
    val size: String,

)

@Composable
@Preview
fun BagProductListPreview() {
    BagProductList( product = BagProduct(
        id = 1,
        name = "Shirt",
        price = 4.5,
        color = "Blue",
        imageUrl = "",
        size = "XL",
    ),
        onQuantityChange = {}

    )
}