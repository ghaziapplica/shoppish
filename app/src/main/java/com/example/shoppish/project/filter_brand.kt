package com.example.shoppish.project

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.MainViewModel
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersBrand(navController: NavController,viewModel: ShopViewModel) {

    TopAppBarDefaults.topAppBarColors(

    )

    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())
    val isScrolled = remember { derivedStateOf { scrollBehavior.state.contentOffset < -80f } }
    val topAppBarElementColor = if (isScrolled.value) {
        Color.White

    } else {
        Color.White
    }
        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor =(colorResource(id = R.color.box_color)),
                        titleContentColor = (colorResource(id = R.color.text_color)),
                    ),
                    title = {
                        Text(
                            viewModel.filterTxt,
                            color = (colorResource(id = R.color.text_color)),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigate(ShopScreen.BrandFilter.route) }) {
                            Icon(
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "go back",
                                tint = (colorResource(id = R.color.text_color))
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* do something */ }) {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Search",
                                tint = (colorResource(id = R.color.text_color))
                            )
                        }
                    },
                    scrollBehavior = scrollBehavior,
                )
            },
        ) { innerPadding ->
            ScrollContent(innerPadding)
        }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Your other composables go here...

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .height(104.dp)
                .background(Color.White,)
                .shadow(2.dp, RectangleShape, true)

        ) {
            // Your content here

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background((colorResource(id = R.color.box_color))),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                )  {
                    Button(
                        onClick = {  },
                        modifier = Modifier
                            .size(width = 160.dp, height = 38.dp)
                            .padding(end = 13.dp),
                        shape = RoundedCornerShape(26.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6347)) // Use the orange color
                    ) {
                        androidx.compose.material.Text(
                            text = "Discard",
                            color = Color.White,
                            fontSize = 14.sp,
                            fontFamily = metropolisFamilyFont
                        )
                    }
                    OutlinedButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .height(36.dp)
                            .width(160.dp)
                            .background(colorResource(id = R.color.box_color))
                            .height(38.dp),
                        shape = RoundedCornerShape(20.dp), // Set the corner shape to 10.dp rounded
                        border = BorderStroke(1.dp, (colorResource(id = R.color.text_color))), // Set the border to 1.dp black
                    ) {
                        Text(text = "Apply", color = (colorResource(id = R.color.text_color)),
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.Normal,
                                fontSize = 14.sp
                            ),
                        )
                    }
                }
            }

        }
    }
    }


@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    // Replace with your content
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(innerPadding)
    ) {
        FilterScreen( navController = rememberNavController(),
            viewModel = ShopViewModel())
    }
}
@Composable
fun FilterScreen(navController: NavController,
                 viewModel: ShopViewModel){

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.box_color))
        ){
            Text(text = viewModel.priceTxt,
                style = TextStyle(
                    color = (colorResource(id = R.color.text_color)),
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize =  18.sp),
                modifier = Modifier.padding(start = 18.dp, top = 18.dp)
            )

            Spacer(modifier =   Modifier.padding(18.dp))

            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background((colorResource(id = R.color.box_color)))
            ){

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(start = 18.dp, end = 18.dp, top = 24.dp)

                ) {
                    Row (

                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ){
                        Text(text = "$${viewModel.sliderPosition.value.start.toInt()}",
//                        modifier = Modifier.padding(end = 270.dp),
                            style = TextStyle(
                                color = (colorResource(id = R.color.text_color)),
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),)
                        Text(text = "$${viewModel.sliderPosition.value.endInclusive.toInt()}",
                            style = TextStyle(
                                color = (colorResource(id = R.color.text_color)),
                                fontFamily = metropolisFamilyFont,
                                fontWeight = FontWeight.SemiBold,
                                fontSize =  16.sp),
                            modifier = Modifier.padding(end = 7.dp))
                    }

                    RangeSlider(
                        modifier = Modifier.semantics { contentDescription = "Localized Description" },
                        value = viewModel.sliderPosition.value,
                        onValueChange = { viewModel.sliderPosition.value = it },
                        valueRange = 10f..1000f,
                        onValueChangeFinished = {
                            // launch some business logic update with the state you hold
                            // viewModel.updateSelectedSliderValue(sliderPosition)
                        },
                        colors = SliderDefaults.colors(
                            thumbColor =  Color(0xFFDB3022), // Change the color of the thumb
                            activeTrackColor =  Color(0xFFDB3022), // Change the color of the active track
                            inactiveTrackColor = Color.Gray // Change the color of the inactive track
                        )
                    )
                }

            }
            Text(text = viewModel.colorTxt,
                style = TextStyle(
                    color = (colorResource(id = R.color.text_color)),
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize =  18.sp),
                modifier = Modifier.padding(start = 18.dp, top = 18.dp)
            )

            Spacer(modifier =   Modifier.padding(12.dp))
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(colorResource(id = R.color.box_color))
            ){
                Row(
                    horizontalArrangement = Arrangement.spacedBy(24.dp),
                    modifier = Modifier.padding(20.dp)
                ) {
                    viewModel.filterColors.forEachIndexed { index, color ->
                        androidx.compose.material3.Button(
                            onClick = { viewModel.selectedButton.value = index },
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = Color(android.graphics.Color.parseColor(color))
                            ),
                            modifier = Modifier
                                .width(37.dp)
                                .height(37.dp)
                                .clip(CircleShape)
                                .border(
                                    width = if (viewModel.selectedButton.intValue == index) 2.dp else 0.dp,
                                    color = (colorResource(id = R.color.text_color)),
                                    shape = CircleShape
                                )
//                            .padding(2.dp)
                        ) {}
                    }
                }
            }
            Spacer(modifier =   Modifier.padding(12.dp))
            Text(text = viewModel.sizeTxt,
                style = TextStyle(
                    color =(colorResource(id = R.color.text_color)),
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize =  18.sp),
                modifier = Modifier.padding(start = 18.dp, bottom = 18.dp)
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(colorResource(id = R.color.box_color))
            ){

                Row (
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 18.dp, end = 18.dp),
                    horizontalArrangement = Arrangement.spacedBy(24.dp),

                    ){

                    viewModel.filterSizes.forEachIndexed{ index, size ->
                        androidx.compose.material3.Button(
                            onClick = { viewModel.selectedButton2.intValue = index },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .size(width = 50.dp, height = 50.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF9B9B9B),
                                    RoundedCornerShape(10.dp)
                                ),

                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = if (viewModel.selectedButton2.value == index) Color(
                                    0xFFDB3022
                                ) else Color.White, // Change the background color if this button is selected
                            ), // Use the orange color'
//                            shape = RectangleShape,
                            contentPadding = PaddingValues(start = 15.dp)
                        ) {
                            Text(
                                text = size,
                                color = if (viewModel.selectedButton2.value == index) Color.White else Color.Black,
                                fontSize = 16.sp,
                                fontFamily = metropolisFamilyFont,
                                modifier = Modifier.fillMaxWidth()


                            )
                        }
                    }

                }
            }
            Spacer(modifier =   Modifier.padding(12.dp))
            Text(text = viewModel.categories,
                style = TextStyle(
                    color = (colorResource(id = R.color.text_color)),
                    fontFamily = metropolisFamilyFont,
                    fontWeight = FontWeight.SemiBold,
                    fontSize =  18.sp),
                modifier = Modifier.padding(start = 18.dp, bottom = 18.dp)
            )
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .background(colorResource(id = R.color.box_color))
            ){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp, start = 18.dp, end = 18.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    viewModel.filterCategory.forEachIndexed{ category, size ->
                        androidx.compose.material3.Button(
                            onClick = { viewModel.selectedButton3.value = category },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .size(width = 100.dp, height = 50.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF9B9B9B),
                                    RoundedCornerShape(10.dp)
                                ),

                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = if (viewModel.selectedButton3.value == category) Color(
                                    0xFFDB3022
                                ) else Color.White, // Change the background color if this button is selected
                            ), // Use the orange color'
//                            shape = RectangleShape,
                            contentPadding = PaddingValues(start = 15.dp)
                        ) {
                            Text(
                                text = size,
                                color = if (viewModel.selectedButton3.value == category) Color.White else Color.Black,
                                fontSize = 16.sp,
                                fontFamily = metropolisFamilyFont,
                                modifier = Modifier.fillMaxWidth()


                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 12.dp, start = 18.dp, end = 18.dp),
                    horizontalArrangement = Arrangement.Start,
                ) {
                    viewModel.filterCategory2.forEachIndexed{ category2, size ->
                        androidx.compose.material3.Button(
                            onClick = { viewModel.selectedButton4.value = category2 },
                            shape = RoundedCornerShape(10.dp),
                            modifier = Modifier
                                .size(width = 115.dp, height = 50.dp)
                                .padding(start = 14.dp)
                                .border(
                                    width = 1.dp,
                                    color = Color(0xFF9B9B9B),
                                    RoundedCornerShape(10.dp)
                                ),

                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = if (viewModel.selectedButton4.value == category2) Color(
                                    0xFFDB3022
                                ) else Color.White, // Change the background color if this button is selected
                            ), // Use the orange color'
//                            shape = RectangleShape,
                            contentPadding = PaddingValues(start = 15.dp)
                        ) {
                            Text(
                                text = size,
                                color = if (viewModel.selectedButton4.value == category2) Color.White else Color.Black,
                                fontSize = 16.sp,
                                fontFamily = metropolisFamilyFont,
                                modifier = Modifier.fillMaxWidth()


                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
                    .background(Color.Transparent),
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 18.dp)
                ) {
                    Text(text = "Brands",
                        style = TextStyle(
                            color = (colorResource(id = R.color.text_color)),
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.SemiBold,
                            fontSize =  18.sp),
                    )

                    Text(text = viewModel.filterBrandText,
                        style = TextStyle(
                            color = (colorResource(id = R.color.text_color)),
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize =  12.sp),
                        modifier = Modifier.padding(top = 5.dp)
//                        modifier = Modifier.padding(start = 0.dp, bottom = 18.dp, top = 40.dp, end = 50.dp)
                    )

                }
                Spacer(modifier = Modifier.width(87.dp))
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                        contentDescription = "go",
                        tint = (colorResource(id = R.color.text_color))
                    )
                }

            }

Spacer(modifier = Modifier.height(80.dp))

        }

    }
}


@Composable
@Preview
fun FiltersBrandPreview(){
    FiltersBrand( navController = rememberNavController(),
        viewModel())
}