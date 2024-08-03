package com.example.shoppish.project.MVVM

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppish.R
import com.example.shoppish.project.Product.Child.ChildProduct
import com.example.shoppish.project.Product.Man.ManProduct
import com.example.shoppish.project.Product.Woman.WomanProduct
import kotlinx.coroutines.launch
import java.lang.Exception

class ProductViewModel : ViewModel() {

    val womanProducts = listOf(
        WomanProduct(
            id = 1,
            name = "Woman Dress",
            description = "Beautiful summer dress",
            price = 59.99,
            imageUrlGrid = R.drawable.womangrid.toString(),
            imageUrlGridBig = R.drawable.womangridbig.toString(),
            imageUrlList = R.drawable.womanlist.toString(),
            review = 4.5,
            discount = 10,
            noOfReviews = 50
        ),
        WomanProduct(
            id = 2,
            name = "Woman Top",
            description = "Casual top for women",
            price = 39.99,
            imageUrlGrid = R.drawable.womangrid.toString(),
            imageUrlGridBig = R.drawable.womangridbig.toString(),
            imageUrlList = R.drawable.womanlist.toString(),
            review = 4.0,
            discount = 15,
            noOfReviews = 35
        ),
        WomanProduct(
            id = 3,
            name = "Woman Jeans",
            description = "Stylish jeans for women",
            price = 49.99,
            imageUrlGrid = R.drawable.womangrid.toString(),
            imageUrlGridBig = R.drawable.womangridbig.toString(),
            imageUrlList = R.drawable.womanlist.toString(),
            review = 4.2,
            discount = 20,
            noOfReviews = 45
        )
    )
    val manProducts = listOf(
        ManProduct(
            id = 1,
            name = "Man Suite",
            description = "Eligent Business Coat",
            price = 79.99,
            imageUrlGrid = R.drawable.mangrid.toString(),
            imageUrlGridBig = R.drawable.mangridbig.toString(),
            imageUrlList = R.drawable.manlist.toString(),
            review = 4.7,
            discount = 5,
            noOfReviews = 70
        ),
        ManProduct(
            id = 2,
            name = "Man Coat",
            description = "Eligent Business Coat",
            price = 79.99,
            imageUrlGrid = R.drawable.mangrid.toString(),
            imageUrlGridBig = R.drawable.mangridbig.toString(),
            imageUrlList = R.drawable.manlist.toString(),
            review = 4.7,
            discount = 5,
            noOfReviews = 70
        ),
        ManProduct(
            id = 3,
            name = "Man Paints",
            description = "Eligent Business Coat",
            price = 79.99,
            imageUrlGrid = R.drawable.mangrid.toString(),
            imageUrlGridBig = R.drawable.mangridbig.toString(),
            imageUrlList = R.drawable.manlist.toString(),
            review = 4.7,
            discount = 5,
            noOfReviews = 70
        ),// Add more products as needed
    )
    val childProducts = listOf(
        ChildProduct(
            id = 1,
            name = "Child Shirt",
            description = "Endurable little hoodies",
            price = 35.99,
            imageUrlGrid = R.drawable.childgrid.toString(),
            imageUrlGridBig = R.drawable.childgridbig.toString(),
            imageUrlList = R.drawable.childlist.toString(),
            review = 4.2,
            discount = 20,
            noOfReviews = 120
        ),
        ChildProduct(
            id = 2,
            name = "Child Nicker",
            description = "Endurable little hoodies",
            price = 35.99,
            imageUrlGrid = R.drawable.childgrid.toString(),
            imageUrlGridBig = R.drawable.childgridbig.toString(),
            imageUrlList = R.drawable.childlist.toString(),
            review = 4.2,
            discount = 20,
            noOfReviews = 120
        ),
        ChildProduct(
            id = 3,
            name = "Child Trouser",
            description = "Endurable little hoodies",
            price = 35.99,
            imageUrlGrid = R.drawable.childgrid.toString(),
            imageUrlGridBig = R.drawable.childgridbig.toString(),
            imageUrlList = R.drawable.childlist.toString(),
            review = 4.2,
            discount = 20,
            noOfReviews = 120
        ),
        // Add more products as needed
    )

//    private val _productState = mutableStateOf(ProductState())
//    val productsState: State<ProductState> = _productState
//
//
//    init {
//        fetchProducts()
//    }
//
//
//    private fun fetchProducts(){
//        viewModelScope.launch {
//            try {
//                val response = productService.getCategories()
//                _productState.value = _productState.value.
//                copy(
//                    list = response.categories,
//                    loading = false,
//                    error = null
//                )
//
//            }catch (e: Exception){
//                _productState.value = _productState.value.copy(
//                    loading = false,
//                    error = "Error fetching Categories ${e.message}"
//                )
//            }
//        }
//    }
//
//    data class ProductState(
//        val loading: Boolean = true,
//        val list: List<Category> = emptyList(),
//        val error: String? = null
//    )
}