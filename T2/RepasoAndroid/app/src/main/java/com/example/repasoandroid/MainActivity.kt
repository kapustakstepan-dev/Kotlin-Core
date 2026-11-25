package com.example.repasoandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.repasoandroid.activity.HomeActivity
import com.example.repasoandroid.activity.RegisterActivity
import com.example.repasoandroid.databinding.LoginActivityBinding
import com.example.repasoandroid.dataset.DataSet
import com.example.repasoandroid.model.User
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: LoginActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val intent = Intent(applicationContext, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener {
            val mail: String = binding.editMail.text.toString()
            val pass: String = binding.editPass.text.toString()

            if (mail.isEmpty() || pass.isEmpty()){
                Snackbar.make(binding.root,"Faltan Datos por rellenar", Snackbar.LENGTH_LONG).show()
            } else{

                val user: User? = DataSet.getLogin(mail,pass)
                if (user!=null){
                    val intent = Intent(applicationContext, HomeActivity::class.java)

                    intent.putExtra("user", user)
                    startActivity(intent)

                } else{
                    Snackbar.make(binding.root,"No coencide mail o pass", Snackbar.LENGTH_LONG).show()
                }

            }

        }

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
        binding.editPass.text.clear()
        binding.editMail.text.clear()
    }




}