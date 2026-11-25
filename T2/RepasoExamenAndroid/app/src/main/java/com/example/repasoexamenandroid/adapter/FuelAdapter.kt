package com.example.repasoexamenandroid.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.repasoexamenandroid.R
import com.example.repasoexamenandroid.model.Fuel

class FuelAdapter(
    context: Context,
    private val fuels: List<Fuel>
) : ArrayAdapter<Fuel>(context, 0, fuels){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View? {
        return createView(position, convertView, parent)
    }

    private fun createView(position: Int, convertView: View?, parent: ViewGroup): View{
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.spinner_layout,parent,false)

        val fuel = fuels[position]

        val ivIcon: ImageView = view.findViewById(R.id.ivFuelIcon)
        val tvName: TextView = view.findViewById(R.id.tvFuelName)

        ivIcon.setImageResource(fuel.icon)
        tvName.text = fuel.nameFuel

        return view

    }
}