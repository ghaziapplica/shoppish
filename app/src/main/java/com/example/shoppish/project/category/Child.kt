package com.example.shoppish.project.category

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.shoppish.R
import com.example.shoppish.ui.theme.metropolisFamilyFont

sealed class BoxC
object Box17 : Box()
object Box18 : Box()
object Box19 : Box()
object Box20 : Box()
object Box21 : Box()
object Box22 : Box()
object Box23 : Box()
object Box24 : Box()

@Composable
fun ChildCategory(){
    val boxes = listOf(Box17, Box18, Box19, Box20, Box21, Box22, Box23, Box24)

    LazyColumn {
        items(boxes) { box ->
            when (box) {
                is Box17 -> Box17()
                is Box18 -> Box18()
                is Box19 -> Box19()
                is Box20 -> Box20()
                is Box21 -> Box21()
                is Box22 -> Box22()
                is Box23 -> Box23()
                is Box24 -> Box24()
                else -> {}
            }
            Spacer(modifier = Modifier.height(16.dp)) // Add a Spacer here
        }
    }
}

@Composable
fun Box17() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Red)

    ){

        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.5f)
                .padding(top = 20.dp)
        ){
            Text(text = "SUMMER SALES",
                fontFamily = metropolisFamilyFont,
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Center))


        }



        Box (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .padding(top = 14.dp)
        ){
            Text(text = "Up to 50% off",
                fontFamily = metropolisFamilyFont,
                fontSize = 14.sp,
                color = Color.White,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .align(Alignment.Center))


        }



    }
}

@Composable
fun Box18() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.mannew),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "New",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }

}

@Composable
fun Box19() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)




//                modifier = Modifier
//                .size(343.dp, 100.dp)
//        .fillMaxSize()
//        .clip(RoundedCornerShape(16.dp))
//        .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.manclothes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Clothes",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}

@Composable
fun Box20() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.manshoes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Shoes",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}

@Composable
fun Box21() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.manacc),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Accesories",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}
@Composable
fun Box22() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.mannew),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Accesories",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}
@Composable
fun Box23() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.manclothes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Accesories",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}
@Composable
fun Box24() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.manshoes),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .size(171.dp, 100.dp)
        )
        Text(text = "Accesories",
            fontFamily = metropolisFamilyFont,
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(top = 40.dp, start = 60.dp))
    }
}




@Composable
@Preview(showBackground = true)
fun ChildPreview(){

    ChildCategory()
}

