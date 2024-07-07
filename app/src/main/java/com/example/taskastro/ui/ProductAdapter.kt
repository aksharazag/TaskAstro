package com.example.taskastro.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.taskastro.R
import com.example.taskastro.model.data.Product
import kotlin.coroutines.coroutineContext

class ProductAdapter (
    private val products: List<Product>,
    private val productClickListener : (Product) ->Unit
) : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    // create new views for items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_product, parent, false)
        return ProductViewHolder(view)
    }

    //bind data to those views
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.bind(product,productClickListener)
    }
    // find the number of items in the Product list
    override fun getItemCount(): Int = products.size

    // ViewHolder class holds references to the views within each item layout
    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val productName: TextView = itemView.findViewById(R.id.tvProductName)
        private val productDescription: TextView = itemView.findViewById(R.id.tvProductDescription)
        private val productPrice: TextView = itemView.findViewById(R.id.tvProductPriceValue)
        private val productAuthentic: TextView = itemView.findViewById(R.id.tvProductAuthenticValue)
        private val productImage: ImageView = itemView.findViewById(R.id.ivProduct)

        fun bind(product: Product,productClickListener: (Product) -> Unit) {
            productName.text = product.name
            productDescription.text = product.description
            productPrice.text = product.price.toString()
            productAuthentic.text = product.authentic
            Glide.with(itemView.context).load(product.imagePath.square).into(productImage)

            //product item click listener
            itemView.setOnClickListener {
                productClickListener(product)

            }
        }
    }
}