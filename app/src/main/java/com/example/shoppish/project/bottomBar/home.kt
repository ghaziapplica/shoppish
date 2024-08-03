package com.example.shoppish.project.bottomBar


import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.AppBarCollapsedHeight
import com.example.shoppish.project.MVVM.AppBarExpendedHeight
import com.example.shoppish.project.MVVM.AppBarMidwayHeight
import com.example.shoppish.project.MVVM.HomeViewModel
import com.example.shoppish.project.MVVM.ProductViewModel
import com.example.shoppish.project.Product.Child.ChildGridProduct
import com.example.shoppish.project.Product.Man.ManGridProduct
import com.example.shoppish.project.Product.Woman.WomanGridProduct
import com.example.shoppish.ui.theme.metropolisFamilyFont
import com.example.shoppish.ui.theme.poppinsFamilyFont
import kotlin.math.min


@Composable
fun homeScreen(navController: NavHostController = rememberNavController(),
               onClick: () -> Unit, viewModel: HomeViewModel  ) {

    val scrollState = rememberLazyListState()

    Box(
        modifier = Modifier
            .background(colorResource(id = R.color.box_color))
    ) {
        AccountInfo(scrollState, viewModel = ProductViewModel())
        ProfileToolBar(scrollState, navController, onButtonClick = onClick, viewModel = viewModel)
    }

}
@Composable
fun ProfileToolBar(scrollState: LazyListState,navController: NavController,
                   onButtonClick: () -> Unit,
                   viewModel: HomeViewModel
                   ) {
//    - AppBarCollapsedHeight
    val midwayHeight = with(LocalDensity.current) { AppBarMidwayHeight.roundToPx() }


    val statusBarHeight = LocalWindowInsets.current.systemBars.layoutInsets.top
    val maxOffset = with(LocalDensity.current) {
        (viewModel.imageHeight - AppBarCollapsedHeight).roundToPx()
    } - statusBarHeight

    val offset = min(min(scrollState.firstVisibleItemScrollOffset, maxOffset), midwayHeight)
    val offsetProgress = offset.toFloat() / maxOffset.toFloat()


    Log.d("ProfileToolBar", "offsetProgress: $offsetProgress")


    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = Color.White,
        modifier = Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset {
                IntOffset(x = 0, y = -offset)
            },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(viewModel.imageHeight)

            )
            {



                val imageResId = if (offsetProgress >= .96f) viewModel.imageWhenAppBarIsCollapsed else viewModel.imageWhenAppBarIsExpanded
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = "Background",
                    modifier = if (imageResId == viewModel.imageWhenAppBarIsCollapsed) {
                        Modifier
                            .width(395.dp)
                            .height(210.dp)

                            .align(Alignment.BottomCenter)
                    } else {
                        Modifier.fillMaxSize()
                    },
                    contentScale = ContentScale.FillBounds // This will make the image scale to fill the size of the Box
                )
                Row(
                    modifier = Modifier
                        .fillMaxHeight()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val textSize = if (imageResId == viewModel.imageWhenAppBarIsCollapsed) 34.sp else 48.sp

                        val text = if (offsetProgress >= .96f)"Street clothes" else "Fashion \nsale"
                        Text(text = text,
                            fontSize = textSize,
                            fontWeight = FontWeight.Black,
                            color = Color.White,
                            fontFamily = poppinsFamilyFont,
                            modifier = if (imageResId == viewModel.imageWhenAppBarIsCollapsed){
                                Modifier
                                    .padding(top = 360.dp)
                                    .padding(end = 80.dp)



                            } else {
                                Modifier
                                    .padding(top = 200.dp)
                                    .padding(end = 120.dp)
                            }

                        )

                        if (imageResId == viewModel.imageWhenAppBarIsExpanded) {
                            Button(
                                onClick = { onButtonClick() },
                                modifier = Modifier
                                    .size(width = 160.dp, height = 36.dp)
                                    .align(Alignment.Start)
                                    .padding(start = 10.dp),
                                shape = RoundedCornerShape(26.dp),
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFFF6347)) // Use the orange color
                            ) {
                                Text(
                                    text = "Check",
                                    color = Color.White,
                                    fontSize = 14.sp,
                                    fontFamily = metropolisFamilyFont
                                )
                            }
                        }

                    }
                }
            }

        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .height(196.dp)
            .padding(horizontal = 16.dp)
    ) {

    }
}



@Composable
fun AccountInfo(scrollState: LazyListState,
                viewModel: ProductViewModel) {
    val womanProducts = viewModel.womanProducts
    val manProducts = viewModel.manProducts
    val childProducts = viewModel.childProducts

    LazyColumn(contentPadding = PaddingValues(top = AppBarExpendedHeight),
        state = scrollState,) {
        item {
            Column(
                modifier = Modifier.padding(start = 14.dp, top = 33.dp)
            ){
                // First horizontal scroll view

                Row {
                    Text(
                        text = "Sale",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = metropolisFamilyFont,
                        color = (colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding()
                    )
                    Text(
                        text = "View All",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = metropolisFamilyFont,
                        color =(colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding(start = 240.dp, top = 10.dp)
                    )


                }


                Text(
                    text = "Super summer sale",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = metropolisFamilyFont,
                    color = Color(0xFF9B9B9B),
                    modifier = Modifier.padding(bottom = 22.dp)
                )


                LazyRow {



                    items(20) { // Replace 20 with the number of times you want to display the image
                        WomanGridProduct(product = womanProducts[0], imageUrl = womanProducts[0].imageUrlGrid)

                        Spacer(modifier = Modifier.width(10.dp)) // Add space between images
                    }
                }

                Spacer(modifier = Modifier.height(30.dp)) // Add space between the two horizontal scroll views

                Row {
                    Text(
                        text = "New",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = metropolisFamilyFont,
                        color = (colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding()
                    )
                    Text(
                        text = "View All",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = metropolisFamilyFont,
                        color = (colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding(start = 240.dp, top = 10.dp)
                    )


                }


                Text(
                    text = "You’ve never seen it before!",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = metropolisFamilyFont,
                    color = Color(0xFF9B9B9B),
                    modifier = Modifier.padding(bottom = 22.dp)
                )

                // Second horizontal scroll view
                LazyRow {
                    items(20) { // Replace 20 with the number of times you want to display the image
                        ManGridProduct(product = manProducts[0], imageUrl = manProducts[0].imageUrlGrid)

                        Spacer(modifier = Modifier.width(10.dp)) // Add space between images
                    }
                }
                Spacer(modifier = Modifier.height(30.dp)) // Add space between the two horizontal scroll views

                Row {
                    Text(
                        text = "Popular",
                        fontSize = 34.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = metropolisFamilyFont,
                        color = (colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding()
                    )
                    Text(
                        text = "View All",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = metropolisFamilyFont,
                        color =(colorResource(id = R.color.text_color)), // This color changes based on the theme
                        modifier = Modifier.padding(start = 240.dp, top = 10.dp)
                    )


                }


                Text(
                    text = "Most popular clothes for you",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Light,
                    fontFamily = metropolisFamilyFont,
                    color = Color(0xFF9B9B9B),
                    modifier = Modifier.padding(bottom = 22.dp)
                )

                // Second horizontal scroll view
                LazyRow {
                    items(20) { // Replace 20 with the number of times you want to display the image
                        ChildGridProduct(product = childProducts[0], imageUrl = childProducts[0].imageUrlGrid)

                        Spacer(modifier = Modifier.width(10.dp)) // Add space between images
                    }

                }
                Spacer(modifier = Modifier.height(80.dp))
            }
            }
        }
    }





@Composable
@Preview (showBackground = true)
fun HomeScreenPreview() {
    val navController = rememberNavController()
    homeScreen(navController = navController,onClick = {}, viewModel ())
}