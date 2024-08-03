package com.example.shoppish.project.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.HomeViewModel
import com.example.shoppish.project.neww.DetailsScreen

import com.example.shoppish.ui.theme.metropolisFamilyFont

@Composable
fun NewCollection(bottomBar: @Composable () -> Unit,
                  viewModel: HomeViewModel,
                  navController: NavController
){

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )

    }


    Scaffold(
        bottomBar = bottomBar,

    ){
            paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            // Existing NewCollection content...


                Image(
                    painter = painterResource(id = viewModel.collectionImg),
                    contentDescription = "",
                    modifier = Modifier
                        .height(390.dp)
                        .padding(bottom = 7.dp)
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .clickable { navController.navigate(DetailsScreen.Product.route)  })

            Text(text = viewModel.productType1,
                fontFamily = metropolisFamilyFont,
                fontSize = 35.sp,
                color = Color.White,
                fontWeight = Bold,
                modifier = Modifier
                    .padding(start = 110.dp, top = 305.dp)
                    .align(Alignment.TopStart))


            Box (
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .fillMaxHeight(0.553f)
                    .padding(bottom = 35.dp))
            {

                Column (
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .align(Alignment.CenterEnd)
                        .fillMaxHeight()
                ) {
                    Image(
                        painter = painterResource(id = viewModel.hoodiImg),
                        contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize())
                }
                Column(
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .align(Alignment.CenterStart)
                            .fillMaxHeight()
                        ){

                   Box (
                       modifier = Modifier.fillMaxSize()
                   ){


                       Image(
                           painter = painterResource(id = viewModel.blackImg),
                           contentDescription = "",
                           modifier = Modifier
                               .fillMaxSize()
                               .align(Alignment.CenterEnd)
                               .padding(top = 193.dp)
                       )

                       Text(text = viewModel.productType2,
                           fontFamily = metropolisFamilyFont,
                           fontSize = 35.sp,
                           color = Color(0xFFD60000),
                           fontWeight = Bold,
                           modifier = Modifier
                               .padding(start = 15.dp,top = 59.dp)
                               .align(Alignment.TopStart))
                       Text(text = viewModel.productType4,
                           fontFamily = metropolisFamilyFont,
                           fontSize = 35.sp,
                           color = Color.White,
                           fontWeight = Bold,
                           modifier = Modifier
                               .padding(start = 15.dp,top = 302.dp)
                               .align(Alignment.TopStart))

                   }

                }



            }







        }
    }
}

@Composable
@Preview (showBackground = true)
fun CollectionPreview () {
    NewCollection(bottomBar = {}, viewModel(), navController = rememberNavController())
}