package com.example.shoppish.project.MVVM.navigation
////
//import android.annotation.SuppressLint
//import androidx.compose.foundation.layout.height
//import androidx.compose.material.BottomNavigation
//import androidx.compose.material.BottomNavigationItem
//import androidx.compose.material.Icon
//import androidx.compose.material.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.navigation.NavController
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.currentBackStackEntryAsState
//import androidx.navigation.compose.rememberNavController
//import com.example.shoppish.R
//import com.example.shoppish.project.MVVM.NavigationController
//import com.example.shoppish.ui.theme.poppinsFamilyFont
//
//
//@SuppressLint("ResourceAsColor")
//@Composable
//
//fun Navigation(navController: NavHostController) {
//
//    val items = listOf(
//        NavigationItem.Home,
//        NavigationItem.Shop,
//        NavigationItem.Bag,
//        NavigationItem.Favorites,
//        NavigationItem.Profile
//    )
//    Scaffold (
//        bottomBar = {
//
//            BottomNavigation(
//                modifier = Modifier.height(83.dp),
//                backgroundColor = MaterialTheme.colors.background,
//                elevation = 10.dp,) {
//
//                val navBackStackEntry by navController.currentBackStackEntryAsState()
//                val currentRoute = navBackStackEntry?.destination?.route
//
//                items.forEach {
//                    BottomNavigationItem(selected = currentRoute == it.route,
//                        modifier = Modifier.height(150.dp),
//                        label = {
//                            Text(
//                                text = it.label,
//                                fontSize = 10.sp,
//                                fontFamily = poppinsFamilyFont
//
//                                ,
//                            )
//                        },
//
//                        onClick = {
//                            if (currentRoute != it.route) {
//
//                                navController.graph?.startDestinationRoute?.let {
//                                    navController.popBackStack(it, true)
//                                }
//
//                                navController.navigate(it.route) {
//                                    launchSingleTop = true
//                                }
//
//                            }
//
//                        },
//
//                        icon = {
//                            Icon(
//                                imageVector = if (currentRoute == it.route) it.selectedIcon else it.icons,
//                                contentDescription = null,
//                                tint = if (currentRoute == it.route)  Color.Black else Color.LightGray
//                            )
//                        },
//
//                        )
//
//                }
//            }
//
//
//        }) {
//        val padding = it
//
//        NavigationController(navController = navController)
//
//    }
//
//}
//    @Composable
//    @Preview
//    fun NavigationPreview() {
//        Navigation( navController = rememberNavController())
//    }
