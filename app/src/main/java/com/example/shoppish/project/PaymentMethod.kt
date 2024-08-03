package com.example.shoppish.project

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.shoppish.R
import com.example.shoppish.project.BottomSheets.NewCardBottomSheet
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethods(navController: NavController){

    var cardHolderName = "Jennyfer Doe"
    val expiryMonth = 5
    val expiryDate = 23
    var expiryFullDate = "$expiryMonth/$expiryDate"
    var isChecked by remember { mutableStateOf(true) }
    val cardNumber = 5546820536933947L

    var cardHolderName2 = "Jennyfer Doe"
    val expiryMonth2 = 11
    val expiryDate2 = 22
    var expiryFullDate2 = "$expiryMonth2/$expiryDate2"
    var isCheckedd by remember { mutableStateOf(false) }
    val cardNumber2 = 6511544835004546L

    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                NewCardBottomSheet( )
            }
        }
    }

    fun formatCardNumber(cardNumber: Long): String {
        val cardStr = cardNumber.toString()
        val masked = cardStr.take(12).replace(Regex("[0-9]"), " *")
        val visiblePart = cardStr.drop(12)
        val formatted = (masked + visiblePart).chunked(8).joinToString(" ")
        return formatted
    }

    fun formatCardNumber2(cardNumber2: Long): String {
        val cardStr2 = cardNumber2.toString()
        val masked2 = cardStr2.take(12).replace(Regex("[0-9]"), " *")
        val visiblePart2 = cardStr2.drop(12)
        val formatted2 = (masked2 + visiblePart2).chunked(8).joinToString(" ")
        return formatted2
    }

    val formattedCardNumber = formatCardNumber(cardNumber)
    val formattedCardNumber2 = formatCardNumber2(cardNumber2)

//    LaunchedEffect(isChecked, isCheckedd) {
//        when {
//            isChecked -> if (!isCheckedd) isChecked = false
//            isCheckedd -> if (isChecked) isCheckedd = true
//        }
//    }
Box (
    modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFF9F9F9))
){
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9)),
    ){
        TopAppBar(
            modifier = Modifier
                .height(80.dp)
                .background(Color.White),
            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "`Payment Methods`", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize =  21.sp),
                        modifier = Modifier.padding(top = 30.dp)
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back button click here */ },
                    modifier = Modifier.padding(top = 10.dp)) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back", tint = Color.Black)
                }
            },
            actions = {
                IconButton(onClick = {  },
                    modifier = Modifier.padding(top = 10.dp)) {
                    Icon(Icons.Filled.Search, contentDescription = "Search", tint = Color.Black)
                }
            },
        )
        Column() {
            Text(text = "Your payment cards",
                style = TextStyle(
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize =  18.sp),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 10.dp, top = 30.dp, bottom = 29.dp)

            )
        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){


            Box (
                modifier = Modifier
                    .width(344.dp)
                    .height(216.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(if (isChecked) Color(0xFF232223) else Color(0xFF9A9A9B))


            ){

                Image(painter = painterResource(id = R.drawable.cardbackone),
                    contentDescription = null,
                    modifier = Modifier
                        .width(288.dp)
                        .height(116.dp)
                        .align(Alignment.BottomStart),
                )
                Image(painter = painterResource(id = R.drawable.cardellipse),
                    contentDescription = null,
                    modifier = Modifier
                        .width(118.dp)
                        .height(126.dp)
                        .align(Alignment.TopEnd),
                )
                Image(painter = painterResource(id = R.drawable.cardsiim),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 34.dp)
                        .width(32.dp)
                        .height(24.dp)
                        .align(Alignment.TopStart),
                )
                Image(painter = painterResource(id = R.drawable.cardmaster),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 34.dp, bottom = 24.dp)
                        .width(32.dp)
                        .height(24.dp)
                        .align(Alignment.BottomEnd),
                )


                Text(text = formattedCardNumber,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize =  24.sp),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 87.dp)
                )

                Text(text = "Card Holder Name",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize =  10.sp),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 152.dp)
                )
                Text(text = cardHolderName,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize =  14.sp),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 171.dp)
                )
                Text(text = expiryFullDate,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize =  14.sp),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 179.dp, top = 171.dp)
                )
                Text(text = "Expiry Date",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize =  11.sp),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 179.dp, top = 152.dp)
                )


            }


        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 31.dp, start = 16.dp),
        ){
            Box (
                modifier = Modifier
                    .size(30.dp)
                    .padding(bottom = 5.dp)
            ){
                Checkbox(
                    checked = isChecked,
                    onCheckedChange = { isChecked = it },

                    )
            }

            Text(text = "Use as default payment method",
                fontFamily = metropolisFamilyFont,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top =  3.dp, start = 13.dp))

        }
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {

            Box(
                modifier = Modifier
                    .width(344.dp)
                    .height(216.dp)
                    .clip(shape = RoundedCornerShape(10.dp))
                    .background(if (isCheckedd) Color(0xFF232223) else Color(0xFF9A9A9B))


            ) {

                Image(
                    painter = painterResource(id = R.drawable.cardbackone),
                    contentDescription = null,
                    modifier = Modifier
                        .width(288.dp)
                        .height(116.dp)
                        .align(Alignment.BottomStart),
                )
                Image(
                    painter = painterResource(id = R.drawable.cardellipse),
                    contentDescription = null,
                    modifier = Modifier
                        .width(118.dp)
                        .height(126.dp)
                        .align(Alignment.TopEnd),
                )
                Image(
                    painter = painterResource(id = R.drawable.cardsiim),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 34.dp)
                        .width(32.dp)
                        .height(24.dp)
                        .align(Alignment.TopStart),
                )
                Image(
                    painter = painterResource(id = R.drawable.visa),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(end = 34.dp, bottom = 24.dp)
                        .width(32.dp)
                        .height(24.dp)
                        .align(Alignment.BottomEnd),
                )


                Text(
                    text = formattedCardNumber2,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 24.sp
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 87.dp)
                )

                Text(
                    text = "Card Holder Name",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 10.sp
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 152.dp)
                )
                Text(
                    text = cardHolderName2,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 24.dp, top = 171.dp)
                )
                Text(
                    text = expiryFullDate2,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 179.dp, top = 171.dp)
                )
                Text(
                    text = "Expiry Date",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 11.sp
                    ),
                    color = Color.White,
                    modifier = Modifier
                        .padding(start = 179.dp, top = 152.dp)
                )


            }
        }
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 25.dp, bottom = 31.dp, start = 16.dp),
        ){
            Box (
                modifier = Modifier
                    .size(30.dp)
                    .padding(bottom = 5.dp)
            ){
                Checkbox(
                    checked = isCheckedd,
                    onCheckedChange = { isCheckedd = it },

                    )
            }

            Text(text = "Use as default payment method",
                fontFamily = metropolisFamilyFont,
                fontSize = 16.sp,
                color = Color.Black,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top =  3.dp, start = 13.dp))

        }

    }
    Box(
        modifier = Modifier
            .size(75.dp)
            .align(Alignment.BottomEnd)
    ) {
        FloatingActionButton(
            onClick = { isSheetOpen = true },
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
@Preview
fun PaymentMethodsPreview(){
    PaymentMethods(navController = NavController(LocalContext.current))
}