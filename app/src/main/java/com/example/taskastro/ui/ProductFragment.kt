package com.example.taskastro.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels

import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskastro.R
import com.example.taskastro.model.data.Product

import com.example.taskastro.viewmodel.ProductViewModel

class ProductFragment : Fragment() {

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rv: RecyclerView = view.findViewById(R.id.rvProductList)
        rv.layoutManager = LinearLayoutManager(context)
        rv.adapter = ProductAdapter(listOf()){selectedProductItem->
            productItemClickListener(selectedProductItem)
        }

        productViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            productAdapter = ProductAdapter(products){item -> productItemClickListener(item)}
            rv.adapter = productAdapter
        })

        productViewModel.errorMessage.observe(viewLifecycleOwner, Observer { message ->
            // Handle error message
        })

        productViewModel.fetchProducts()

    }

    private fun productItemClickListener(selectedProductItem:Product) {

        val productData = Bundle().apply {
            putString("productName", selectedProductItem.name)
            putString("productDescription", selectedProductItem.description)
        }

        findNavController().navigate(R.id.action_productFragment_to_productDetailsFragment,productData)

        // Toast.makeText(requireContext(), selectedProductItem.name,Toast.LENGTH_LONG).show()

    }
}