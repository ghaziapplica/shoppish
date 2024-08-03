package com.example.shoppish.project.Product.Woman

data class WomanProduct(
    val id: Int,
    val name: String,
    val description: String,
    val price: Double,
    val imageUrlGrid: String,
    val imageUrlGridBig: String,
    val imageUrlList: String,
    val review: Double,
    val discount: Int,
    val noOfReviews: Int
)
