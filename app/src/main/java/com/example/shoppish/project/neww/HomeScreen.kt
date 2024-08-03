package com.example.shoppish.project.neww

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.project.MVVM.MainViewModel
import com.example.shoppish.ui.theme.poppinsFamilyFont

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    navController: NavHostController = rememberNavController(),
    mainViewModel: MainViewModel
) {
    Scaffold(
        bottomBar = {
            if (mainViewModel.showBottomBar.value) {
                BottomBar(navController = navController)
            }
        }
    ) {
        HomeNavGraph(
            rootNavController = navController,
            mainViewModel = mainViewModel
        )
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Shop,
        BottomBarScreen.Bag,
        BottomBarScreen.Favorites,
        BottomBarScreen.Profile,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    val bottomBarDestination = screens.any { screen ->
        currentDestination?.hierarchy?.any { it.route == screen.route } == true ||
                currentDestination?.route?.startsWith(screen.route) == true
    }

    if (bottomBarDestination) {
        BottomNavigation(
            modifier = Modifier.height(83.dp),
            backgroundColor = MaterialTheme.colorScheme.background,
            elevation = 10.dp,
        ) {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(
        modifier = Modifier.height(150.dp),
        label = {
            Text(
                text = screen.label,
                fontSize = 10.sp,
                fontFamily = poppinsFamilyFont
            )
        },
        icon = {
            val iconPainter = if (currentDestination?.hierarchy?.any { it.route == screen.route } == true) {
                painterResource(id = screen.selectedIcon)
            } else {
                painterResource(id = screen.icons)
            }
            Icon(
                painter = iconPainter,
                contentDescription = "Navigation Icon",
                modifier = Modifier.size(30.dp),
                tint = Color.Unspecified
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}

@Composable
@Preview
fun ScreenPreview() {
    BottomBar(rememberNavController())
}
