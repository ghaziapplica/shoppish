package com.example.shoppish.project


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.project.neww.BagsScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@Composable
fun CancelledPreview(navController: NavController) {
    val namesAddresses = listOf(
        CancelledInfo(1947034,"IW3475453455", 3, 150, "12-12-2021"),
        CancelledInfo(1947034,"IW3475453455", 3, 150, "12-12-2021"),
        // Add more PersonInfo objects as needed
    )


    Box {


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9)),
        ) {





            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(namesAddresses) { nameAddress ->
                    CancelledBox(
                        order = nameAddress.orderNo.toString(),
                        tracking = nameAddress.trackingNumber,
                        quantity = nameAddress.quantity.toString(),
                        total = nameAddress.total,
                        date = nameAddress.date,


                        )
                    Spacer(modifier = Modifier.height(24.dp))
                }
            }

        }

    }
}

@Composable
fun CancelledBox(order: String, tracking: String, quantity: String, total: Int, date: String) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(Color.White)
            .width(343.dp)
            .height(164.dp)


    ) {
        Column(
            modifier = Modifier.padding(start = 19.dp, end = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    text =   "Order №$order", color = Color.Black,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text =   date, color = Color.Gray,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp, start = 28.dp)
                )
            }
            Row (
                modifier = Modifier.padding()
            ){
                Text(
                    text =   "Tracking number:", color = Color.Gray,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp)
                )
                Text(
                    text =   tracking, color = Color.Black,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 18.dp, start = 10.dp)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                Row {
                    Text(
                        text =   "Quantity:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp)
                    )
                    Text(
                        text =   quantity, color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, start = 11.dp)
                    )
                }
                Row {
                    Text(
                        text =   "Total Amount:", color = Color.Gray,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, start = 8.dp)
                    )
                    Text(
                        text =   "$$total", color = Color.Black,
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.padding(top = 10.dp, start = 11.dp)
                    )

                }
            }
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 14.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                OutlinedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.height(36.dp)
                        .width(100.dp),
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
                Text(
                    text =   "Cancelled", color =  Color.Red,
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 14.sp
                    ),
                    modifier = Modifier.padding(top = 8.dp, )
                )

            }
        }
        // Additional content can be added here

    }
}
data class CancelledInfo(
    val orderNo: Int,
    val trackingNumber: String,
    val quantity: Int,
    val total: Int,
    val date: String,
)

@Composable
@Preview
fun CancelledScreen(){
    CancelledPreview( navController = rememberNavController())
}