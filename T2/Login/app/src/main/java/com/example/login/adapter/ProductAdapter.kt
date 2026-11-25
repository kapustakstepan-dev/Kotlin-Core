package com.example.login.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.R
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.databinding.ActivityMainBinding
import com.example.login.databinding.ItemProductBinding
import com.example.login.model.Product

class ProductAdapter(var list: List<Product>, var context: Context) :
    RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductAdapter.MyHolder {
        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(context),
            parent,false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductAdapter.MyHolder, position: Int) {
        val product: Product = list[position]
        holder.binding.textTitle.text = product.title
        holder.binding.textPrice.text = product.price.toString()

        Glide.with(context).load(product.image).placeholder(R.drawable.foto_login)
            .into(holder.binding.imageProduct)
        }

    override fun getItemCount(): Int {
        return list.size
    }


}