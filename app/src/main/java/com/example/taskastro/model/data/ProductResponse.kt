package com.example.taskastro.model.data

class ProductResponse(
    val products: Map<String, Product>
)

data class Product(
    val name: String,
    val description: String,
    val availableLanguages: List<String>,
    val pages: Int,
    val pagesintext: String,
    val report_type: String,
    val authentic: String,
    val remedies: String,
    val vedic: String,
    val price: Int,
    val discount: Int,
    val appDiscount: Int,
    val couponDiscount: Int,
    val imagePath: ImagePath,
    val soldcount: String,
    val avg: Double
)

data class ImagePath(
    val square: String,
    val wide: String
)

