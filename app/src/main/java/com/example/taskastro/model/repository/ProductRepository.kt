package com.example.taskastro.model.repository

import com.example.taskastro.model.network.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
class ProductRepository {
    private val apiService: ApiService

    init {
        //Retrofit Builder class for creating and executing http request
        val retrofit = Retrofit.Builder()
            .baseUrl("https://apps.clickastro.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    fun getProducts() = apiService.getProducts()
}