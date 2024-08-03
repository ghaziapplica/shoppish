package com.example.shoppish.project.neww


import com.example.shoppish.R

sealed class BottomBarScreen(
    val route: String,
    val label: String,
    val icons: Int,
    val selectedIcon: Int,
    val hasNews: Boolean,
    val badges: Int
)

{

    object Home : BottomBarScreen(
        "home",
        "Home",
        R.drawable.home,
        R.drawable.homeclicked,
        hasNews = true,
        badges = 2)
    object Shop : BottomBarScreen(
        "shop",
        "Shop",
        R.drawable.shop,
        R.drawable.shopclicked,
        hasNews = true,
        badges = 0)

    object Bag : BottomBarScreen(
        "bag",
        "Bag",
        R.drawable.bag,
        R.drawable.bagclicked,
        hasNews = true,
        badges = 0)
    object Favorites: BottomBarScreen(
        "favorites",
        "Favorites",
        R.drawable.favunselected,
        R.drawable.favselected,
        hasNews = true,
        badges = 0)

    object Profile: BottomBarScreen(
        "profile",
        "Profile",
        R.drawable.profile,
        R.drawable.profileclicked,
        hasNews = true,
        badges = 0)

}
