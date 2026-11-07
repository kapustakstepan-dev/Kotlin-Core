package com.example.login.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.login.R
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.databinding.ItemProductBinding
import com.example.login.model.Product

class ProductAdapter(var list: List<Product>, var context: Context) : RecyclerView.Adapter<ProductAdapter.MyHolder>() {

    inner class MyHolder(var binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {
        //en el xml


    }

    //crear el patron general
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyHolder {

        val binding: ItemProductBinding = ItemProductBinding.inflate(LayoutInflater.from(context),
            parent, false)
        return MyHolder(binding)
    }

    //los elementos que ves en la pantalla.asocia lo grafico (MyHolder) con un dato (posicion de una lista)
    override fun onBindViewHolder(
        holder: MyHolder,
        position: Int
    ) {
        //holder.binding.image

        //recomendable hacer asi SIEMPRE
        val product: Product = list[position]
        holder.binding.titulo.text = product.title
        holder.binding.precio.text = product.price.toString()
        //holder.binding.image.setImageResource()
        Glide.with(context).load(product.image).placeholder(R.drawable.foto_login)
            .into(holder.binding.image)

    }

    //cantidad de elementos a mostrar en total ->el size de una lista
    override fun getItemCount(): Int {
        return list.size
    }

}