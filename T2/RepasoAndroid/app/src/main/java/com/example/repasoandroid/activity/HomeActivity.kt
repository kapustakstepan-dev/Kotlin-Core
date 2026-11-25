package com.example.repasoandroid.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.repasoandroid.databinding.HomeActivityBinding
import com.example.repasoandroid.dataset.DataSet
import com.example.repasoandroid.model.User

class HomeActivity: AppCompatActivity() {

    lateinit var binding: HomeActivityBinding
    var user: User? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DataSet.initList()
        getExtras()

    }

    private fun getExtras() {
        if (intent.getSerializableExtra("user") != null){
            user = intent.getSerializableExtra("user") as User
        }
    }

    override fun onStart() {
        super.onStart()
        binding.txtBienvenido.text = "Bienvenido ${user?.name ?: "invitado"}"

        if (user?.profile ==0){
            binding.btnVerUsers.visibility = View.VISIBLE
        } else{
            binding.btnVerUsers.visibility = View.GONE
            binding.txtInfo.text = "Te llamas ${user?.name} -- Tu correo es ${user?.mail}"
        }

    }

    override fun onResume() {
        super.onResume()
        binding.btnLogOut.setOnClickListener { finish() }
        binding.btnVerUsers.setOnClickListener {
            var textInfo =""
            for (i in DataSet.userList){
                textInfo += "${i.name +"--"+ i.mail}\n"
            }
            binding.txtInfo.text = textInfo
        }

    }


}