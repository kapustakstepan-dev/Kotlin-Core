package com.example.repasoandroid.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.repasoandroid.databinding.RegisterActivityBinding
import com.example.repasoandroid.dataset.DataSet
import com.example.repasoandroid.model.User
import com.google.android.material.snackbar.Snackbar


class RegisterActivity: AppCompatActivity() {

    lateinit var binding: RegisterActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()

        binding.btnVolver.setOnClickListener {
            finish()
        }

        binding.btnRegistrarse.setOnClickListener {

            val name: String = binding.editNameRegister.text.toString()
            val mail: String = binding.editMail.text.toString()
            val pass: String = binding.editPassRegister.text.toString()
            val profile = when(binding.radioGroup.checkedRadioButtonId){
                binding.radioBtnAdmin.id-> 0
                binding.radioBtnUser.id -> 1
                else -> -1
            }

            if (name.isEmpty()||mail.isEmpty()||pass.isEmpty()||profile == -1){
                Snackbar.make(binding.root,"Faltan datos por rellenar", Snackbar.LENGTH_LONG).show()
            } else{
                val userSel = User(name,mail,pass,profile)
                if (DataSet.addUser(userSel)){
                    Snackbar.make(binding.root,"Quieres aniadir el user?", Snackbar.LENGTH_LONG)
                        .setAction("OK"){
                            val intent = Intent(applicationContext, HomeActivity::class.java)
                            intent.putExtra("user", userSel)
                            startActivity(intent)
                            finish()
                        }
                        .show()
                } else{
                    Snackbar.make(binding.root,"No se puede aniadir el user", Snackbar.LENGTH_LONG).show()
                }
            }
        }


        binding.editMail.text.clear()
        binding.editNameRegister.text.clear()
        binding.editPassRegister.text.clear()

    }

    override fun onRestart() {
        super.onRestart()


    }
}