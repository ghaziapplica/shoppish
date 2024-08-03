@file:OptIn(ExperimentalFoundationApi::class)

package com.example.shoppish.project

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppish.project.category.ChildCategory
import com.example.shoppish.project.category.ManCategory
import com.example.shoppish.project.category.WomanCategory
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun CategoryScreen(bottomBar: @Composable () -> Unit) {

    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = false
        )

    }


val tabItems = listOf(
    TabItems(
        title = "Women",
    ),
    TabItems(
        title = "Men",
    ),
    TabItems(
        title = "Kids",
    )
)
    var selectTabIndex by remember { mutableIntStateOf(0) }
    val pagerState = rememberPagerState{ tabItems.size }

    LaunchedEffect(selectTabIndex) {
        pagerState.animateScrollToPage(selectTabIndex)
    }
    LaunchedEffect(pagerState.currentPage) {
        selectTabIndex = pagerState.currentPage
    }

    Column (
        modifier = Modifier.fillMaxSize()
    ) {
        TabRow(selectedTabIndex = selectTabIndex) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = index == selectTabIndex,
                    onClick = {
                        selectTabIndex = index
                    },
                    text = {
                        Text(text = item.title)
                    }
                )
            }
        }

        HorizontalPager(state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.CenterHorizontally)
                .padding(start = 14.dp, bottom = 94.dp,))
        {
            index ->
            when (tabItems[index].title) {
                "Women" -> WomanCategory()
                "Men" -> ManCategory()
                "Kids" -> ChildCategory()
                else -> Text(text = "Unknown category")
            }
        }

    }

}
data class TabItems(
    val title: String,
)

@Composable
@Preview(showBackground = true)
fun CategoryPreview(){

    CategoryScreen(bottomBar = {})
}