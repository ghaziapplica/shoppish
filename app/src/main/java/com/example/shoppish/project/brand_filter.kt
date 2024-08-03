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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.neww.ShopScreen
import com.example.shoppish.ui.theme.metropolisFamilyFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BrandFilter(navController: NavController,
                viewModel: ShopViewModel) {
    TopAppBarDefaults.topAppBarColors(

    )
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor =(colorResource(id = R.color.box_color)),
                    titleContentColor = (colorResource(id = R.color.text_color)),
                ),
                title = {
                    androidx.compose.material3.Text(
                        viewModel.brand,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        color = (colorResource(id = R.color.text_color))
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ShopScreen.ProductScreen.route)}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ) { innerPadding ->
        ContentScroll(innerPadding)
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
                .background(colorResource(id = R.color.box_color))
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
fun ContentScroll(innerPadding: PaddingValues) {
    // Replace with your content
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .verticalScroll(scrollState)
            .padding(innerPadding)
    ) {
        BrandScreen( navController = rememberNavController())
    }
}

@Composable
fun BrandScreen(navController: NavController){
    val searchQuery = remember { mutableStateOf("") }
    val brands = listOf("adidas", "adidas Originals", "Blend", "Boutique Moschino", "Champion", "Diesel", "Jack & Jones", "Naf Naf", "Red Valentino", "s.Oliver")
    val selectedBrands = remember { mutableStateMapOf<String, Boolean>() }
    Box (
        modifier = Modifier
            .fillMaxWidth()
            .height(680.dp)
            .background(colorResource(id = R.color.box_color))
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 36.dp),
//                verticalArrangement = Arrangement.Center, // Add this line
            horizontalAlignment = Alignment.CenterHorizontally
        ){



            Box(
                modifier = Modifier
                    .size(width = 344.dp, height = 40.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color.White),




            ) {
                BasicTextField(
                    value = searchQuery.value,
                    onValueChange = { searchQuery.value = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .padding(start = 40.dp, top = 10.dp),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 16.sp,
                        fontFamily = metropolisFamilyFont,
                        fontWeight = FontWeight.Normal,),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                )
                if (searchQuery.value.isEmpty()) {
                    androidx.compose.material3.Text(
                        text = "Search",
                        style = TextStyle(
                            fontFamily = metropolisFamilyFont,
                            fontWeight = FontWeight.Normal,
                            fontSize =  16.sp),
                        color = Color.Gray,
                        modifier = Modifier
                            .align(Alignment.CenterStart)
                            .padding(start = 40.dp)
                    )
                }
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 10.dp)
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Column (
                modifier = Modifier.padding(20.dp)
            ){
                brands.forEach { brand ->
                    Row(Modifier.fillMaxWidth(), Arrangement.SpaceBetween) {
                        androidx.compose.material3.Text(
                            text = brand,
                            style = TextStyle(
                                fontFamily = metropolisFamilyFont,
                                fontWeight = if (selectedBrands[brand] == true) FontWeight.SemiBold else FontWeight.Normal),
                            color = if (selectedBrands[brand] == true) Color(0xFFDB3022) else (colorResource(id = R.color.text_color))
                        )
                        Checkbox(
                            checked = selectedBrands[brand] == true,
                            onCheckedChange = { isChecked ->
                                selectedBrands[brand] = isChecked
                            },
                            colors = CheckboxDefaults.colors(
                                checkedColor = Color(0xFFDB3022),
                                uncheckedColor = Color.Gray
                            )
                        )
                    }
                }
            }


        }
    }





}
@Composable
@Preview
fun BrandFilterPreview(){
    BrandFilter(
        rememberNavController(),
        viewModel()
    )
}