package com.example.taskastro.model.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    //inserting data to the table
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(products: List<ProductEntity>)

    //select the products from table
    @Query("SELECT * FROM products")
    fun getAllProducts(): LiveData<List<ProductEntity>>
}