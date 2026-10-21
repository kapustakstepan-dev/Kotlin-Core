package com.example.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.login.activity.RegistroActivity
import com.example.login.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        binding.btnLogin.setOnClickListener(this)
        binding.btnRegistro.setOnClickListener(this)




    }

    override fun onRestart() {
        super.onRestart()
        binding.editMail.text.clear()
        binding.editPass.text.clear()
        binding.checkBox.isChecked = false
        binding.radioGroup.clearCheck()
    }


    override fun onClick(v: View?) {
       when(v!!.id){
           binding.btnRegistro.id->{
               val intent: Intent = Intent(this, RegistroActivity::class.java)
               startActivity(intent)

           }
           binding.btnLogin.id->{}

       }
    }

}