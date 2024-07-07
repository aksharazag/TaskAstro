package com.example.taskastro.model.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "product_id")
    val id: String,

    @ColumnInfo(name = "product_name")
    val name: String,

    @ColumnInfo(name = "product_description")
    val description: String,

    val availableLanguages: String,
    val sampleReports: String,
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
    val imagePathSquare: String,
    val imagePathWide: String,
    val soldcount: String,
    val avg: Float
)
