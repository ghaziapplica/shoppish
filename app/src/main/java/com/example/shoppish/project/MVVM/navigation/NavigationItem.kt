package com.example.shoppish.project.MVVM.navigation
//
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Email
//import androidx.compose.material.icons.filled.Favorite
//import androidx.compose.material.icons.filled.Home
//import androidx.compose.material.icons.filled.Person
//import androidx.compose.material.icons.filled.ShoppingCart
//import androidx.compose.material.icons.outlined.Email
//import androidx.compose.material.icons.outlined.FavoriteBorder
//import androidx.compose.material.icons.outlined.Home
//import androidx.compose.material.icons.outlined.Person
//import androidx.compose.material.icons.outlined.ShoppingCart
//import androidx.compose.ui.graphics.vector.ImageVector
//
//sealed class NavigationItem (
//    val route: String,
//    val label: String,
//    val icons: ImageVector,
//    val selectedIcon : ImageVector,
//    val hasNews: Boolean,
//    val badges : Int
//)
//
//{
//
//    object Home : NavigationItem(
//        "home",
//        "Home",
//        Icons.Outlined.Home,
//        Icons.Filled.Home,
//        hasNews = true,
//        badges = 2)
//    object Shop : NavigationItem(
//        "shop",
//        "Shop",
//        Icons.Outlined.ShoppingCart,
//        Icons.Filled.ShoppingCart,
//        hasNews = true,
//        badges = 0)
//
//    object Bag : NavigationItem(
//        "bag",
//        "Bag",
//        Icons.Outlined.Email,
//        Icons.Filled.Email,
//        hasNews = true,
//        badges = 0)
//    object Favorites: NavigationItem(
//        "favorites",
//        "Favorites",
//        Icons.Outlined.FavoriteBorder,
//        Icons.Filled.Favorite,
//        hasNews = true,
//        badges = 0)
//
//    object Profile: NavigationItem(
//        "profile",
//        "Profile",
//        Icons.Outlined.Person,
//        Icons.Filled.Person,
//        hasNews = true,
//        badges = 0)
//
//}