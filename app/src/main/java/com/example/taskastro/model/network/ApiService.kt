package com.example.taskastro.model.network

import com.example.taskastro.model.data.ProductResponse
import com.example.taskastro.model.database.ProductEntity
import retrofit2.Call
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.Retrofit

interface ApiService {
    //adding api endpoints and their http methods
    @GET("test/products.php")
    fun getProducts(): Call<ProductResponse>
}


