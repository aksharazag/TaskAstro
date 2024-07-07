package com.example.taskastro.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskastro.model.data.Product
import com.example.taskastro.model.repository.ProductRepository
import kotlinx.coroutines.launch
import retrofit2.await

class ProductViewModel : ViewModel() {
    val products = MutableLiveData<List<Product>>()
    val errorMessage = MutableLiveData<String>()
    private val repository = ProductRepository()

    fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = repository.getProducts().await()
                products.value = response.products.values.toList()
            } catch (e: Exception) {
                errorMessage.value = e.message
            }
        }
    }
}