package com.example.shoppish.project.bottomBar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.R
import com.example.shoppish.project.CategoryScreen
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.shop.DropDownScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShopScreen(navController: NavHostController = rememberNavController(),
               onClick: () -> Unit, viewModel: ShopViewModel ) {
    Column{


        TopAppBar(
            modifier = Modifier.background(Color.White),

            title = {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = viewModel.categories,
                        color = (colorResource(id = R.color.text_color)),
                        modifier = Modifier,
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Normal,
                        fontStyle = FontStyle.Normal
                    )
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* Handle back button click here */ }) {
                    Icon(viewModel.backArrow, contentDescription = "Back", tint = (colorResource(id = R.color.text_color)))
                }
            },
            actions = {
                IconButton(onClick = { viewModel.isSearchClicked.value = true }) {
                    Icon(viewModel.search, contentDescription = "Search", tint = (colorResource(id = R.color.text_color)))
                }
            },
            )
        if (viewModel.isSearchClicked.value) {
            DropDownScreen(navController = navController, onClick,
                viewModel = ShopViewModel())
        } else {
            CategoryScreen(bottomBar = {})
        }
        CategoryScreen(bottomBar = {})

    }


}




@Composable
@Preview (showBackground = true)
fun ShopPreview () {
    ShopScreen(navController = rememberNavController(), {}, viewModel())
}