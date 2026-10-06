package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //private lateinit var editName: EditText

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        this.setContentView(binding.root)

        /*binding.buttonSaludar.setOnClickListener{
            // it -> quien ha generado el evento -> buttonSaludar
            Log.v("info", "boton saludar pulsado correctamente")
        }

        binding.buttonsalir.setOnClickListener{
            // it -> quien ha generado el evento -> buttonSaludar
            Log.v("info", "boton salir pulsado correctamente")
        }

         */

        binding.buttonSaludar.setOnClickListener(this)
        binding.buttonsalir.setOnClickListener(this)
        binding.buttonLimpiar.setOnClickListener(this)


    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            binding.buttonLimpiar.id->{binding.edirNombre.text.clear()}
            binding.buttonSaludar.id->{
                val nombre : String = binding.edirNombre.text.toString()
                if (nombre.isBlank()){
                    val notificacion = Snackbar.make(p0, "no introdusiste nada",
                        Snackbar.LENGTH_INDEFINITE)
                    notificacion.show()
                } else {
                    val notificacion = Snackbar.make(p0, "enhorabuena $nombre has completado la tarea",
                        Snackbar.LENGTH_INDEFINITE)
                    notificacion.setAction("Cerrar"){notificacion.dismiss()}
                    notificacion.show()
                }
            }
            binding.buttonsalir.id->{
                finish()
            }

        }
    }

}

