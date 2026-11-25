package com.example.examenandroidprimeva.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.examenandroidprimeva.databinding.HomeActivityBinding
import com.example.examenandroidprimeva.notas.ParaAprobar

class HomeActivity: AppCompatActivity() {

    lateinit var binding: HomeActivityBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = HomeActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getExtras()
    }

    private fun getExtras() {
        if (intent.getSerializableExtra("paraAprobar") !=null){
            val paraAprobar = intent.getSerializableExtra("paraAprobar") as? ParaAprobar

            if (paraAprobar!=null){
                binding.txtNota1.text = paraAprobar.nota1.toString()
                binding.txtNota2.text = paraAprobar.nota2.toString()
                binding.txtNota3.text = paraAprobar.nota3.toString()
                binding.txtFFE.text = paraAprobar.FFE.toString()
                binding.txtProyecto.text = paraAprobar.proyecto.toString()



            }
        }
    }

}