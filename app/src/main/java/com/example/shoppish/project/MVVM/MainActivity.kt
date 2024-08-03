package com.example.shoppish.project.MVVM


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.shoppish.project.neww.RootNavigationGraph
import com.example.shoppish.ui.theme.ShoppishTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppishTheme {
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

//                  for filters screen
//                    FilterScreen()

                    //for filter brand screen
//                    FiltersBrand( navController = navController, viewModel = ShopViewModel())

                    // for brand screen
//                   ProductScroll(  rating = product.rating.toDouble() , max = 5)

                    //new (complete app)w2`w
                    RootNavigationGraph()
//                    ShippingAddressesPreview()
//                    AddingAddress()
//                    DeliveredPreview( navController = navController)
//                    MyOrder()
//                    OrderDetails()
//                    Settings()
//                    RecipeScreen()
//                    NewCardBottomSheet()
                    //bag product list
//                    BagProductList(
//                        product = BagProduct(
//                            id = 1,
//                            name = "Shirt",
//                            price = 4.5,
//                            color = "Blue",
//                            imageUrl = "",
//                            size = "XL",
//                        ),
//                        onQuantityChange = {}
//                    )

                    // bag list
//                    BagList()
//                    ListProduct(product = WomanProduct(
//                        id = 1,
//                        name = "Evening Dress",
//                        description = "Dorothy Perkins",
//                        price = 4.5,
//                        imageUrlGrid = "",
//                        imageUrlGridBig = "",
//                        imageUrlList = "",
//                        review = 3.0,
//                        discount = 40,
//                        noOfReviews = 10
//                    ),
//                        imageUrl = "", )
                    // for raing bottom sheet
//                    RatingSheet( isSelected = true,)
//                    Reviews(rating = 4.5,)

                    // for rating reviews
//                    RatingReviews(navController = navController)

//                    PaymentMethods()

                    // for photo picker
//                    PhotoPicker()

                    //for woman top
//                    WomanTop( navController = navController)

                    //for shop screen
//                    ShopScreen(navController)


                    //test screen
//                    com.example.shoppish.project.MediumTopAppBarExample()

                     //for complete app
//                    NavGraph( navController = navController)

                    // New Collection
//                    NewCollection( bottomBar = {})

                    // for ProductScreen
//                    ProductScreen(navController = navController)

                    // Categories
//                    CategoryScreen(bottomBar = {})

                    // checkout screen
//                    CheckoutScreen()

                    //for test screen
//                    TestScreen(
//                        starCount = 5,
//                        lineLength = 50
//                    )
//                    WomanScreen(viewModel = ProductViewModel())
//                    WomanTopProduct(product = Product(
//                        id = 1,
//                        name = "Woman Dress",
//                        description = "Beautiful summer dress",
//                        price = 59.99,
//                        imageUrl = "",
//                        review = 4.5,
//                        discount = 10,
//                        noOfReviews = 50
//                    ),
//                        imageUrl = "".toInt().toString()
//                    )


                }

            }
        }
    }
}






