package com.example.shoppish.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@Composable
fun Success(navController: NavController) {
Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Spacer(modifier = Modifier.height(190.dp))
    Image(
        painter = painterResource(id = R.drawable.bags),
        contentDescription = null,
        modifier = Modifier
            .width(208.dp)
            .height(213.dp))
    Spacer(modifier = Modifier.height(49.dp))

    Text(
        text = "Success!", color = Color.Black,
        style = TextStyle(
            fontFamily = metropolisFamilyFont,
            fontWeight = FontWeight.Bold,
            fontSize = 34.sp
        ),
        modifier = Modifier.padding(top = 18.dp)
    )
    Spacer(modifier = Modifier.height(12.dp))
    Text(
        text = "Your order will be delivered soon. \n " +
                "Thank you for choosing our app!!",
        color = Color.Black,
        style = TextStyle(
            fontFamily = metropolisFamilyFont,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp
        ),
        modifier = Modifier.padding(top = 18.dp)
    )
    Spacer(modifier = Modifier.height(160.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(bottom = 0.dp, top = 23.dp),
    ) {
        Row(
            modifier = Modifier.align(Alignment.Center)
        ) {
            Button(
                onClick = {navController.navigate(BagsScreen.Bag.route)},
                modifier = Modifier
                    .size(width = 343.dp, height = 48.dp)
                    .padding(end = 10.dp),
                shape = RoundedCornerShape(26.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFFDB3022)) // Use the orange color
            ) {
                Text(
                    text = "CONTINUE SHOPPING",
                    color = Color.White,
                    fontSize = 14.sp,
                    fontFamily = metropolisFamilyFont
                )
            }

        }

    }
}
}

@Composable
@Preview(showBackground = true)
fun SuccessScreen(){
    Success(navController = rememberNavController())
}