package com.example.shoppish.project.womanCategories

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.ProductViewModel
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WomanTop( navController: NavController) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior (rememberTopAppBarState())
    val isScrolled = remember { derivedStateOf { scrollBehavior.state.contentOffset < -80f } }
    var isSearchClicked by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)

    }

    val topAppBarElementColor = if (isScrolled.value) {
        Color.White

    } else {
        Color.White
    }
    val topAppBarElementText = if (isScrolled.value) {
       TextStyle(
           fontSize =  24.sp
       )

    } else {
        TextStyle(
            fontSize =  34.sp
        )    }

    if(isSheetOpen){
        ModalBottomSheet(
            sheetState = sheetState ,
            onDismissRequest = { isSheetOpen = false }
        ) {
            Box(modifier = Modifier.background(Color.White)) {
                ModalBottomSheetContent(viewModel = ShopViewModel())
            }
        }
    }


        Scaffold(
            modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
            topBar = {
                Column {

                    LargeTopAppBar(
                        modifier = Modifier
                            // Set the height as per your requirement
                            .nestedScroll(scrollBehavior.nestedScrollConnection),
                        colors = TopAppBarDefaults.smallTopAppBarColors(
                            containerColor = topAppBarElementColor,
                            titleContentColor = colorScheme.primary,
                        ),
                        title = {

                            Text(text = "Women’s tops",
                                style = TextStyle(
                                    color = Color.Black,
                                    fontFamily = metropolisFamilyFont,
                                    fontWeight = FontWeight.Bold,
                                    fontSize =  topAppBarElementText.fontSize,),
                                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                            )


                        },


                        navigationIcon = {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    tint = Color.Black,
                                    contentDescription = "Localized description"
                                )
                            }
                        },

                        actions = {
                            IconButton(onClick = { /* do something */ }) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    tint = Color.Black,
                                    contentDescription = "Localized description"
                                )
                            }
                        },
                        scrollBehavior = scrollBehavior
                    )
                    androidx.compose.material.Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(94.dp),
                        backgroundColor = Color.White,

                        ) {

                        Column(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Column(
                                modifier = Modifier.padding(start = 16.dp,)
                            ) {
                                ClothCategory(viewModel = ShopViewModel())
                            }
                            Column(
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Row (
                                    modifier = Modifier.fillMaxWidth()
                                ){
                                    IconButton(onClick = {isSheetOpen = true }) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.filterimg),
                                            tint = Color.Black,
                                            contentDescription = "Localized description"
                                        )
                                    }
                                    Text(text = "Filters",
                                        modifier = Modifier.padding(top = 18.dp),
                                        style = TextStyle(
                                            color = Black,
                                            fontFamily = metropolisFamilyFont,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 14.sp),

                                        )
                                    IconButton(onClick = {
                                        navController.navigate(ShopScreen.FilterBrand.route)
                                    },
                                        modifier = Modifier.padding(start = 30.dp)
                                        ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.low_high),
                                            tint = Color.Black,
                                            contentDescription = "Localized description",
                                                    modifier = Modifier
                                                        .size(22.dp)
                                                        .padding(end = 0.dp)
                                        )
                                    }
                                    Text(text = "Price: Lowest to high ",
                                        modifier = Modifier.padding(top = 18.dp),
                                        style = TextStyle(
                                            color = Black,
                                            fontFamily = metropolisFamilyFont,
                                            fontWeight = FontWeight.Normal,
                                            fontSize = 14.sp),

                                        )


                                    IconButton(onClick = { isSearchClicked = !isSearchClicked},
                                        modifier = Modifier.fillMaxWidth(),
                                        ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.grid),
                                            contentDescription = "Grid",
                                            tint = Color.Black,
                                            modifier = Modifier.padding(start = 30.dp)
                                        )
                                    }
                                }
                                if (isSearchClicked) {
                                    WomanTopGrid(viewModel = ProductViewModel())
                                } else {
                                    WomanTopList(viewModel = ProductViewModel())
                                }


                            }
                        }



                    }
                }
            },
        ) { values ->
//        ScrollContent( paddingValues)
            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {


                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(values)
                ) {

                    if (isSearchClicked) {
                        WomanTopGrid(viewModel = ProductViewModel())
                    } else {
                        WomanTopList(viewModel = ProductViewModel())
                    }

                }
            }

        }

}

@Composable
fun ModalBottomSheetContent(viewModel: ShopViewModel){
    var selectedButtons = remember { mutableStateOf(List(viewModel.topItems.size) { false }) }
    val selectedBoxColor = Color(0xFFDB3022)

    Column {

        Text(text = "Sort by",
            style = TextStyle(
                color = Black,
                fontFamily = metropolisFamilyFont,
                fontWeight = FontWeight.Bold,
                fontSize =  20.sp),
            modifier = Modifier.padding(start = 18.dp, top = 18.dp)
        )

        viewModel.topItems.forEachIndexed { index, item ->
            Button(
                onClick = {
                    selectedButtons.value = List(viewModel.topItems.size) { it == index }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (selectedButtons.value[index]) selectedBoxColor else Color.White,
                    contentColor = if (selectedButtons.value[index]) Color.White else selectedBoxColor
                ),
                shape = RectangleShape,
                modifier = Modifier
                    .height(60.dp)
                    .fillMaxWidth(),


            ) {
                Box(
                    modifier = Modifier.fillMaxSize(),

                    ) {
                    Text(text = item,
                        style = TextStyle(
                            color = if (selectedButtons.value[index]) Color.White else Color.Black,
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Medium,
                            fontSize =  18.sp),
                        modifier = Modifier.align(Alignment.CenterStart)

                        )
                }

            }
        }
    }
}
@Composable
fun ClothCategory(viewModel: ShopViewModel){

    LazyRow {
        items(viewModel.clothItems) { item ->
            Button(
                onClick = { /* Handle button click here */ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.black),
                    contentColor = colorResource(id = R.color.white),
                ),
                modifier = Modifier
                    .height(40.dp)
                    .width(100.dp)
                    .padding(2.dp)
            ) {
                Text(text = item,
                    modifier = Modifier.padding(bottom = 1.dp),
                    )
            }
        }
    }
}



@Composable
@Preview
fun WomanTopPreview() {
    WomanTop(navController = rememberNavController())
}