package com.example.shoppish.project.bottomBar

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberImagePainter
import com.example.shoppish.project.BottomSheets.PromoCodeSheet
import com.example.shoppish.project.neww.ProfileDetailScreen
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavController) {


    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val context = LocalContext.current
    var name = "Matilda Brown"
    var email = "matildabrown@mail.com"

    val pickImageLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
        onResult = { uri: Uri? ->
            imageUri = uri
            // Crop the image to 64x64 here or in onResult before setting it
        }
    )

    var myOrdertxt = "Already have 12 orders"
    var ShippingAddresses = "3 ddresses"
    var PaymentMethods = "Visa  **34"
    var Promocodes = "You have special promocodes"
    var Reviewstxt = "Reviews for 4 items"
    var Settings = "Notifications, password"

    var isSheetOpen by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                PromoCodeSheet()
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF9F9F9))
                .padding(top = 20.dp),
            verticalArrangement = Arrangement.Top
        ){
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, bottom = 10.dp),
                horizontalArrangement = Arrangement.End,
            ){
                Icon(
                    Icons.Filled.Search,
                    contentDescription = "Search",
                    tint = Color.Black,
                    modifier = Modifier
                        .size(36.dp)
                        .clickable {  navController.navigate(ShopScreen.FilterBrand.route) }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp),
                horizontalArrangement = Arrangement.Start,
            ){
                Text(
                    text = "My Profile",
                    style = TextStyle(
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Bold,
                        fontSize = 36.sp
                    ),
                    color = Color.Black,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Column(
                    modifier = Modifier
                        .padding(start = 16.dp, top = 10.dp)
                ) {
                    Box(modifier = Modifier
                        .size(64.dp)
                        .clip(CircleShape)
                        .padding(start = 17.dp, top = 17.dp)
                        .clickable { pickImageLauncher.launch("image/*") }
                        .align(Alignment.Start)
                    ) {
                        if (imageUri != null) {
                            Image(
                                painter = rememberImagePainter(imageUri),
                                contentDescription = "Profile Picture",
                                modifier = Modifier.size(64.dp)
                            )
                        } else {
                            // Placeholder for profile picture
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = "Default Profile Picture",
                                modifier = Modifier.size(64.dp)
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(start = 19.dp)
                ) {
                    Row {

                        Text(
                            text = name,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 18.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )

                    }
                    Row {
                        Text(
                            text = email,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
            }

            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "My orders",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = myOrdertxt,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { navController.navigate(ProfileDetailScreen.MyOrders.route) }
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "Shipping addresses",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = ShippingAddresses,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { navController.navigate(ProfileDetailScreen.ShippingScreenN.route) }
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "Payment methods",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = PaymentMethods,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable {  navController.navigate(ProfileDetailScreen.PaymentScreenN.route) }
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "Promocodes",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = Promocodes,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { isSheetOpen = true }
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "My reviews",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = Reviewstxt,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable {  navController.navigate(ProfileDetailScreen.ReviewsN.route) }
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp, start = 16.dp, end = 16.dp)
            ){
                Column {
                    Row {
                        Text(
                            text = "Settings",
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                    Row {
                        Text(
                            text = Settings,
                            color = Color.Black,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Light,
                                fontSize = 11.sp
                            ),
                            modifier = Modifier.padding(top = 18.dp)
                        )
                    }
                }
                Column {
                    Icon(
                        Icons.Filled.KeyboardArrowRight,
                        contentDescription = "Search",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable {navController.navigate(ProfileDetailScreen.Settings.route)}
                    )
                }
            }
            TabRowDefaults.Divider(
                color = Color.LightGray,
                thickness = 0.4.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )


        }
    }

}

@Composable
@Preview
fun ProfileScreenPreview() {
    ProfileScreen( navController = rememberNavController())
}