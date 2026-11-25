package com.example.examenandroidprimeva

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isEmpty
import com.example.examenandroidprimeva.R
import com.example.examenandroidprimeva.R.array.spinner_notas
import com.example.examenandroidprimeva.activity.HomeActivity
import com.example.examenandroidprimeva.databinding.ActivityMainBinding
import com.example.examenandroidprimeva.notas.ParaAprobar
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onStart() {
        super.onStart()

        binding.btnVer.setOnClickListener {
            val name: String = binding.editName.text.toString()
            val nota1 = binding.spinnerNota1.selectedItem.toString().toInt()
            val nota2 = binding.spinnerNota2.selectedItem.toString().toInt()
            val nota3 = binding.spinnerNota3.selectedItem.toString().toInt()

            val FFE: Boolean = binding.checkFFE.isChecked
            val proyect: Boolean = binding.checkProyect.isChecked

            val paraAprobar = ParaAprobar(name,nota1,nota2,nota3,FFE,proyect)


            if (name.isEmpty()){
                Snackbar.make(binding.root,"Faltan Datos por rellenar", Snackbar.LENGTH_LONG).show()
            } else {
                val intent = Intent(applicationContext, HomeActivity::class.java)
                intent.putExtra("paraApobar", paraAprobar)
                startActivity(intent)

            }


        }


    }

    override fun onRestart() {
        super.onRestart()
    }
}