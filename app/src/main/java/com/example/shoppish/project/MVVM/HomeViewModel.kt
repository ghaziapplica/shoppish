package com.example.shoppish.project.MVVM

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.shoppish.R

class HomeViewModel : ViewModel() {

    val imageHeight = AppBarExpendedHeight
    val imageWhenAppBarIsExpanded = R.drawable.collaps
    val imageWhenAppBarIsCollapsed = R.drawable.aftercollaps

    var isSearchClicked = mutableStateOf(false)

    val productType1 = "New collection"
    val productType2 = "Summer\n  \n sales"
    val productType3 = "Men's \nhoodies"
    val productType4 = "Black"

    val collectionImg = R.drawable.newcollection
    val hoodiImg = R.drawable.hoodi
    val blackImg = R.drawable.black

//    val midwayHeight = with(LocalDensity.current) { AppBarMidwayHeight.roundToPx() }
//    Dp
}