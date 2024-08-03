package com.example.shoppish.project.neww

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.project.MVVM.MainViewModel
@Composable
fun RootNavigationGraph() {
    val rootNavController = rememberNavController()

    NavHost(
        navController = rootNavController,
        route = Graph.ROOT,
        startDestination = Graph.AUTHENTICATION
    ) {
        authNavGraph(navController = rootNavController)
        composable(route = Graph.HOME) {
            HomeScreen(mainViewModel = MainViewModel())
            //start()
        }
    }
}
object Graph {
    const val ROOT = "root_graph"
    const val AUTHENTICATION = "auth_graph"
    const val HOME = "home_graph"
    const val DETAILS = "details_graph"
    const val BAGS = "bags_graph"
    const val SHOP = "shop_graph"
    const val PROFILE = "shop_details_graph"
}