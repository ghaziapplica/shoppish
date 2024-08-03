package com.example.shoppish.project.womanCategories


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.shoppish.project.Product.FavProduct
import com.example.shoppish.project.Product.FavProductList
import com.example.shoppish.project.Product.Product

@Composable
fun FavTopList(){

    val dummyProduct = Product(
        id = 1,
        name = "Evening Dress",
        description = "Dorothy Perkins",
        price = 4.5,
        imageUrl = "",
        review = 3.0,
        discount = 40,
        noOfReviews = 10
        // Add other required fields here
    )
    val dummyFavProduct = FavProduct(
        id = 1,
        name = "Shirt",
        company = "Dorothy Perkins",
        price = 4.5,
        color = "Blue",
        imageUrl = "",
        review = 3.0,
        size = "XL",
        noOfReviews = 10,
        discount = 40,
        // Add other required fields here
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(20) {
                Box (

                ){
                    FavProductList(product = dummyFavProduct )
                }

            }

        }
    }
}

@Composable
@Preview
fun FavTopListPreview(){
    FavTopList()
}
