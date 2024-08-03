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
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.shoppish.project.MVVM.ProductViewModel
import com.example.shoppish.project.Product.Woman.WomanGridProduct
import com.example.shoppish.project.Product.Product

@Composable
fun WomanTopGrid(viewModel: ProductViewModel) {

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

    LazyColumn(
        modifier = Modifier.fillMaxSize()

    ) {
        items(20) { item ->
            Row {
                Box(
                    modifier = Modifier.padding(end = 16.dp, start = 20.dp)
                ) {

                        WomanGridProduct(product = womanProducts[0], imageUrl = womanProducts[0].imageUrlGrid)

                }
                Box {
                    WomanGridProduct(product = womanProducts[0], imageUrl = womanProducts[0].imageUrlGrid)

                        }
            }

        }
    }
}
@Composable
@Preview(showBackground = true)
fun WomanTopGridPreview(){
    WomanTopGrid(viewModel())
}