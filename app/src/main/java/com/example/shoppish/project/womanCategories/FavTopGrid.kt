package com.example.shoppish.project.womanCategories


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shoppish.project.Product.FavProduct

@Composable
fun FavTopGrid() {

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

    LazyColumn(
        modifier = Modifier.fillMaxSize()

    ) {
        items(20) { item ->
            Row {
                Box(
                    modifier = Modifier.padding(end = 16.dp, start = 20.dp)
                ) {
//                    FavProductGrid( )
                }
                Box {
//                    FavProductGrid(product = dummyFavProduct,navController = rememberNavController())
                }
            }

        }
    }
}
@Composable
@Preview(showBackground = true)
fun FavTopGridPreview(){
    FavTopGrid()
}