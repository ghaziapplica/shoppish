package com.example.shoppish.project.neww

import Settings
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.shoppish.project.AddingAddress
import com.example.shoppish.project.BrandFilter
import com.example.shoppish.project.Checkout
import com.example.shoppish.project.DeliveredPreview
import com.example.shoppish.project.FiltersBrand
import com.example.shoppish.project.MVVM.HomeViewModel
import com.example.shoppish.project.MVVM.MainViewModel
import com.example.shoppish.project.MVVM.ShopViewModel
import com.example.shoppish.project.MyOrder
import com.example.shoppish.project.OrderDetails
import com.example.shoppish.project.PaymentMethods
import com.example.shoppish.project.Product.Product
import com.example.shoppish.project.Product.ProductItem
import com.example.shoppish.project.home.NewCollection
import com.example.shoppish.project.Product.ProductScreen
import com.example.shoppish.project.Reviews
import com.example.shoppish.project.ShippingAddressesPreview
import com.example.shoppish.project.Success
import com.example.shoppish.project.bottomBar.BagScreen
import com.example.shoppish.project.bottomBar.Favorities
import com.example.shoppish.project.bottomBar.ProfileScreen
import com.example.shoppish.project.bottomBar.ShopScreen
import com.example.shoppish.project.bottomBar.homeScreen
import com.example.shoppish.project.womanCategories.WomanTop

@Composable
fun HomeNavGraph(  rootNavController: NavHostController,
                 mainViewModel: MainViewModel
) {
    NavHost(
        navController = rootNavController,
        route = Graph.HOME,
        startDestination = BottomBarScreen.Home.route
    ) {
        composable(route = BottomBarScreen.Home.route) {
            homeScreen(
                navController = rootNavController,
                viewModel = HomeViewModel(),
                onClick = {
                    rootNavController.navigate(Graph.DETAILS)


                }
            )

        }
        composable(route = BottomBarScreen.Profile.route) {
           ProfileScreen( navController = rootNavController)
        }
        composable(route = BottomBarScreen.Bag.route) {
            BagScreen(navController = rootNavController,)
        }
        composable(route = BottomBarScreen.Shop.route) {
            ShopScreen( navController = rootNavController,
                onClick = {
                    rootNavController.navigate(Graph.SHOP)
                },
                viewModel = ShopViewModel()
            )
        }
        composable(route = BottomBarScreen.Favorites.route) {
            Favorities( navController = rootNavController )
        }

        detailsNavGraph(navController = rootNavController)
        shopNavGraph(navController = rootNavController)
        bagsNavGraph(navController = rootNavController)
        profileNavGraph(navController = rootNavController)
    }
}

fun NavGraphBuilder.detailsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.DETAILS,
        startDestination = DetailsScreen.Collection.route
    ) {

        composable(route = DetailsScreen.Collection.route) {
            NewCollection( bottomBar = {}, viewModel = HomeViewModel(), navController = navController) // Replace this with your actual CollectionScreen composable
        }
        composable(route = DetailsScreen.Product.route) {
            ProductScreen(navController = navController) // Replace this with your actual CollectionScreen composable
        }

    }
}
fun NavGraphBuilder.shopNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.SHOP,
        startDestination = ShopScreen.Shop.route
    ) {
        composable(route = ShopScreen.Shop.route) {
            WomanTop(navController = navController)// Replace this with your actual CollectionScreen composable
        }
        composable(route = ShopScreen.WomanTop.route) {
            WomanTop(navController = navController)

        }
//        composable(route = ShopDetailsScreen.WomanTop.route) {
//            FiltersBrand(navController = navController, mainViewModel = MainViewModel())
//            }
        composable(route = ShopScreen.FilterBrand.route) {
            FiltersBrand(navController = navController, viewModel = ShopViewModel())
        }
        composable(route = ShopScreen.BrandFilter.route) {
            BrandFilter(navController = navController,
            viewModel = ShopViewModel())
        }
        composable(route = ShopScreen.ProductScreen.route) {
            ProductScreen(navController = navController)
        }
        composable(route = ShopScreen.Product.route) {
            ProductItem(navController = navController,
                product = Product(
                    id = 1,
                    name = "Evening Dress",
                    description = "Dorothy Perkins",
                    price = 3.5,
                    imageUrl = "",
                    review = 4.5,
                    discount = 40,
                    noOfReviews = 10
                )
            )

        }
        composable(route = ShopScreen.RatingScreen.route) {
            Reviews(  rating = 4.5, max = 5)
        }
        }
    }
fun NavGraphBuilder.bagsNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.BAGS,
        startDestination = BagsScreen.Bag.route
    ) {

//        composable(route = BagsScreen.Bag.route) {
//            BagScreen( navController = navController)
//        }
        composable(route = BagsScreen.Red.route) {
            Checkout( navController = navController)
        }
        composable(route = BagsScreen.Payment.route) {
            PaymentMethods(navController = navController)
        }
        composable(route = BagsScreen.Shipping.route) {
            ShippingAddressesPreview( navController = navController)
        }
        composable(route = BagsScreen.Address.route) {
            AddingAddress()
        }
        composable(route = BagsScreen.Success.route) {
            Success(navController = navController)
        }

    }
}
fun NavGraphBuilder.profileNavGraph(navController: NavHostController) {
    navigation(
        route = Graph.PROFILE,
        startDestination = ProfileDetailScreen.Profile.route
    ) {

        composable(route = ProfileDetailScreen.Profile.route) {
            ProfileScreen( navController = navController)
        }
        composable(route = ProfileDetailScreen.BagsScreenN.route) {
            BagScreen( navController = navController)
        }
        composable(route = ProfileDetailScreen.ShippingScreenN.route) {
            ShippingAddressesPreview( navController = navController)
        }
        composable(route = ProfileDetailScreen.PaymentScreenN.route) {
            PaymentMethods(navController = navController)
        }
        composable(route = ProfileDetailScreen.ReviewsN.route) {
            Reviews(  rating = 4.5, max = 5)
        }
        composable(route = ProfileDetailScreen.MyOrders.route) {
            MyOrder(navController = navController)
        }
        composable(route = ProfileDetailScreen.DeliveredPreview.route) {
            DeliveredPreview( navController = navController,)
        }
        composable(route = ProfileDetailScreen.OrderDetails.route) {
            OrderDetails()
        }
        composable(route = ProfileDetailScreen.Settings.route) {
            Settings()
        }



    }
}




sealed class DetailsScreen(val route: String) {
    object Collection : DetailsScreen(route = "COLLECTION")
    object Product : DetailsScreen(route = "PRODUCT")
}

sealed class BagsScreen(val route: String) {
    object Bag : BagsScreen(route = "Bag")
    object Red : BagsScreen(route = "Red")
    object Payment : BagsScreen(route = "PAYMENT")
    object Shipping : BagsScreen(route = "SHIPPING")
    object Address : BagsScreen(route = "ADDRESS")
    object Success : BagsScreen(route = "SUCCESS")

}

sealed class ShopScreen(val route: String) {
    object Shop : ShopScreen(route = "SHOP")
    object WomanTop : ShopScreen(route = "WOMAN_TOP")
    object FilterBrand : ShopScreen(route = "FILTER_BRAND")
    object BrandFilter : ShopScreen(route = "BRAND_FILTER")
    object ProductScreen : ShopScreen(route = "PRODUCT_SCREEN")
    object RatingScreen : ShopScreen(route = "RATING_SCREEN")
    object Product : ShopScreen(route = "PRODUCT")
}
sealed class ProfileDetailScreen(val route: String) {
    object Profile : ProfileDetailScreen(route = "PROFILE")
    object BagsScreenN : ProfileDetailScreen(route = "BAGSCREENN")
    object ShippingScreenN : BagsScreen(route = "SHIPP")
    object PaymentScreenN : BagsScreen(route = "PAYMENTT")
    object ReviewsN : BagsScreen(route = "REVIEWSS")
    object MyOrders : BagsScreen(route = "MYORDERS")
    object DeliveredPreview : BagsScreen(route = "DELIVEREDPREVIEW")
    object OrderDetails : BagsScreen(route = "ORDERDETAILS")
    object Settings : BagsScreen(route = "SETTINGS")

}






//navController.navigate(ShopDetailsScreen.RatingScreen.route)