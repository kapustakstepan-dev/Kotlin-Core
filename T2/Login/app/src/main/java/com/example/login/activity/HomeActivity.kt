package com.example.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login.adapter.ProductAdapter
import com.example.login.data.DataSet
import com.example.login.databinding.ActivityHomeBinding
import com.example.login.model.User

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private var user: User? = null
    private lateinit var adapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataSet.initList()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        instances()
        initGUI()
        actions()
        getExtras()
    }

    private fun actions() {
        binding.recycleProducts.adapter
    }

    private fun initGUI() {
        binding.recycleProducts.adapter = adapter
        if (resources.configuration.orientation ==1){
            binding.recycleProducts.layoutManager =
                LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        } else{
            binding.recycleProducts.layoutManager =
                GridLayoutManager(this,2, LinearLayoutManager.VERTICAL, true)

        }

    }

    private fun instances() {

        //no poner applicationContext SIEMPRE this
        adapter = ProductAdapter(DataSet.listProducts, this)
    }

    fun getExtras() {
        if (intent.getSerializableExtra("user") != null) {
            user = intent.getSerializableExtra("user") as User
        }
    }

    override fun onStart() {
        super.onStart()
        binding.textSaludo.text = "Bienvenido ${user?.name ?: " invidado"}"
    }

    override fun onResume() {
        super.onResume()
        binding.btnLogOut.setOnClickListener { finish() }
    }
}