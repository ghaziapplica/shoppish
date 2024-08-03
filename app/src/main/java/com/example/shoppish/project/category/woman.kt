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

sealed class Box
object Box1 : Box()
object Box2 : Box()
object Box3 : Box()
object Box4 : Box()
object Box5 : Box()
object Box6 : Box()
object Box7 : Box()
object Box8 : Box()

@Composable
fun WomanCategory(){
    val boxes = listOf(Box1, Box2, Box3, Box4, Box5, Box6, Box7, Box8)

    LazyColumn {
        items(boxes) { box ->
            when (box) {
                is Box1 -> Box1()
                is Box2 -> Box2()
                is Box3 -> Box3()
                is Box4 -> Box4()
                is Box5 -> Box5()
                is Box6 -> Box6()
                is Box7 -> Box7()
                is Box8 -> Box8()
                else -> {}
            }
            Spacer(modifier = Modifier.height(16.dp)) // Add a Spacer here
        }
    }
}

@Composable
fun Box1() {
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
fun Box2() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.newcat),
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
fun Box3() {
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
            painter = painterResource(id = R.drawable.clothscat),
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
fun Box4() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.shoescat),
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
fun Box5() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.accesscat),
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
fun Box6() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.newcat),
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
fun Box7() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.clothscat),
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
fun Box8() {
    Box(
        modifier = Modifier
            .size(360.dp, 100.dp)
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White)
    ){

        Image(
            painter = painterResource(id = R.drawable.shoescat),
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
fun WomanPreview(){

    WomanCategory()
}