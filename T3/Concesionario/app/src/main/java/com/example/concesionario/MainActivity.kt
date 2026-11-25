package com.example.concesionario

import android.os.Binder
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.GeneratedAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.concesionario.adapter.ModelAdapter
import com.example.concesionario.data.DataSet
import com.example.concesionario.databinding.ActivityMainBinding
import com.example.concesionario.model.Marca

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterMarca: ArrayAdapter<Marca>
    private lateinit var adapterModel: ModelAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        actions()
        initGUI()


    }

    private fun initGUI() {
        binding.recycleModels.adapter = adapterModel
        binding.recycleModels.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

    }

    private fun instances() {
        adapterMarca = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            DataSet.listaMarca)

        adapterMarca.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerMarca.adapter = adapterMarca

        adapterModel = ModelAdapter(DataSet.listModel, this)
    }

    private fun actions() {
        binding.spinnerMarca.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val marca:Marca = parent!!.adapter.getItem(position) as Marca
                Log.v("test_spinner", "cambio de seleccion a marca: ${marca.name}")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                Log.v("test_spinner", "no hay seleccion")

            }



        }

    }


}