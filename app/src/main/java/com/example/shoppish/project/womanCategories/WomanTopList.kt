package com.example.shoppish.project.womanCategories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppish.project.MVVM.ProductViewModel
import com.example.shoppish.project.Product.Woman.WomanListProduct
import com.example.shoppish.project.Product.Product

@Composable
fun WomanTopList(viewModel: ProductViewModel){

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
    val womanProducts = viewModel.womanProducts

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(20) {
                Box (

                ){
                    WomanListProduct(product = womanProducts[0], imageUrl = womanProducts[0].imageUrlList)
                }

            }

        }
    }
}

@Composable
@Preview
fun WomanTopDGridPreview(){
    WomanTopList(viewModel())
}



