package com.example.shoppish.project.MVVM

import androidx.compose.foundation.BorderStroke
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.shoppish.R
import com.example.shoppish.project.CategoryScreen
import com.example.shoppish.project.shop.DropDownScreen

class ShopViewModel : ViewModel() {

    val showBottomBar = mutableStateOf(true)
    val boxColor = R.color.box_color
    val textColor = R.color.text_color
    var isSearchClicked = mutableStateOf(false)
    val categories = "Categories"
    val backArrow = Icons.AutoMirrored.Filled.ArrowBack
    val search = Icons.Filled.Search

    @Composable
    fun getScreen(navController: NavController, onClick: () -> Unit): @Composable () -> Unit {
        return if (isSearchClicked.value) {
            { DropDownScreen(navController = navController, onClick = onClick, viewModel = this) }
        } else {
            { CategoryScreen(bottomBar = {}) }
        }
    }

    val categoriesList = listOf(
        "Dresses", "Skirts", "Shorts", "Jeans", "Pants",
        "Outerwear", "Blazers", "Knitwear", "Cardigans & Sweaters",
        "Shirts & Blouses", "Tops"
    )

    val viewAll = "VIEW ALL ITEMS"
    val choose = "Choose category"

    val topItems = listOf(
        "Popular",
        "Newest",
        "Customer review",
        "Price: Lowest to high",
        "Price: High to low"
    )
    val clothItems = listOf("T-shirts", "Sleeveless", "Crop tops", "Caps", "Trousers")

    val selectedButton = mutableIntStateOf(-1)
    val selectedButton2 = mutableIntStateOf(-1)
    val selectedButton3 = mutableIntStateOf(-1)
    val selectedButton4 = mutableIntStateOf(-1)

    val filterColors = listOf("#151867", "#E2BB8D", "#BEA9A9", "#B82222", "#F6F6F6", "#020202")
    val filterSizes = listOf("XS", "S", "M", "L", "XL")
    val filterCategory = listOf("All", "Woman", "Men")
    val filterCategory2 = listOf("Boys", "Girls")
    var filterBrandText = "Your selected brands will show up here"
    val filterBorder = BorderStroke(1.dp, Color.Red)
    val filterSelectedBoxColor = Color(0xFFDB3022)
    val filterTxt = "Filter"
    val priceTxt = "Price Range"
    val colorTxt = "Colors"
    val sizeTxt = "Sizes"
    val categoryTxt = "Category"
    var sliderPosition = mutableStateOf(10f..1000f)

    val brand = "Brand"

}
