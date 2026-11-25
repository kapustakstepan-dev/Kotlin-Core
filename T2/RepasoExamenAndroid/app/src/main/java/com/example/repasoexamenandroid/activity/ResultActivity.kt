package com.example.repasoexamenandroid.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.result.ActivityResult
import androidx.appcompat.app.AppCompatActivity
import com.example.repasoexamenandroid.R
import com.example.repasoexamenandroid.databinding.ResultActivityBinding
import com.example.repasoexamenandroid.model.Car
import com.example.repasoexamenandroid.model.Fuel

class ResultActivity: AppCompatActivity() {

    private lateinit var binding: ResultActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ResultActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("name") ?:""
        val surname = intent.getStringExtra("surname") ?:""
        val matricula = intent.getStringExtra("matricula")?:""
        val anioMatricula= intent.getIntExtra("anioMatricula", 0)
        val autonomia = intent.getIntExtra("autonomia", 0)
        val tipoCombustible = intent.getLongExtra("tipoCombustible", -1L)

        binding.txtNombre.text = "Nombre: ${name}"
        binding.txtMatricula.text = "Maricula: ${matricula}"
        binding.txtSurname.text = "Apellido: ${surname}"
        binding.txtAnioMatricula.text = "Anio matricula: ${anioMatricula}"


        val nombreCombustible = when(tipoCombustible){
            0L ->{"Diesel"}
            1L ->{"Gasolina"}
            2L->{"Hibrido"}
            3L->{"Electrico"}
            else -> {"No hay"}
        }
        binding.tipoCombustible.text = "Tipo combustible: ${nombreCombustible}"

        fun getEtiquetas(): Int {
            return when(tipoCombustible){
                Fuel.ELECTRICO -> R.drawable.etiqueta_zero
                Fuel.HIBRIDO ->
                    if (autonomia>80) {
                        R.drawable.etiqueta_zero
                    } else{
                        R.drawable.etiqueta_eco
                    }
                Fuel.DIESEL ->
                    if (anioMatricula in 2006..2015) {
                        R.drawable.etiqueta_c
                    } else {
                        R.drawable.etiqueta_b
                    }
                Fuel.GASOLINA ->
                    if (anioMatricula in 2008 ..2017){
                        R.drawable.etiqueta_c
                    } else {
                        R.drawable.etiqueta_b
                    }
                else -> R.drawable.etiqueta_b

            }
        }

        binding.imagenEtiqueta.setImageResource(getEtiquetas())

    }



    override fun onStart() {
        super.onStart()
    }

    override fun onRestart() {
        super.onRestart()
    }


}