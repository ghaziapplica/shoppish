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

sealed class BoxM
object Box9 : Box()
object Box10 : Box()
object Box11 : Box()
object Box12 : Box()
object Box13 : Box()
object Box14 : Box()
object Box15 : Box()
object Box16 : Box()

@Composable
fun ManCategory(){
    val boxes = listOf(Box9, Box10, Box11, Box12, Box13, Box14, Box15, Box16)

    LazyColumn {
        items(boxes) { box ->
            when (box) {
                is Box9 -> Box9()
                is Box10 -> Box10()
                is Box11 -> Box11()
                is Box12 -> Box12()
                is Box13 -> Box13()
                is Box14 -> Box14()
                is Box15 -> Box15()
                is Box16 -> Box16()
                else -> {}
            }
            Spacer(modifier = Modifier.height(16.dp)) // Add a Spacer here
        }
    }
}

@Composable
fun Box9() {
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
fun Box10() {
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
fun Box11() {
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
fun Box12() {
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
fun Box13() {
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
fun Box14() {
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
fun Box15() {
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
fun Box16() {
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
fun ManPreview(){

    ManCategory()
}