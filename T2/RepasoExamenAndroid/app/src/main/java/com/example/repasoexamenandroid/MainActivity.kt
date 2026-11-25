package com.example.repasoexamenandroid

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.repasoexamenandroid.activity.ResultActivity
import com.example.repasoexamenandroid.adapter.FuelAdapter
import com.example.repasoexamenandroid.databinding.ActivityMainBinding
import com.example.repasoexamenandroid.model.Car
import com.example.repasoexamenandroid.model.Fuel
import com.google.android.material.snackbar.Snackbar
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinnerAdapter()

    }


    override fun onStart() {
        super.onStart()
        binding.btnSegir.setOnClickListener(this)
    }

    //para limpiar editText
    override fun onRestart() {
        super.onRestart()
        binding.editName.text.clear()
        binding.editSurname.text.clear()
        binding.editMatricula.text.clear()
        binding.editAutonomia.text.clear()
        binding.editAnioMatricula.text.clear()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            binding.btnSegir.id -> {
                val name: String = binding.editName.text.toString().trim()
                val surname: String = binding.editSurname.text.toString().trim()
                val matricula: String = binding.editMatricula.text.toString().trim()
                val anioMatricula: Int =
                    binding.editAnioMatricula.text.toString().trim().toIntOrNull() ?: 0
                val autonomia: Int = binding.editAutonomia.text.toString().trim().toIntOrNull() ?: 0
                val tipoCombustible: Long = binding.spinnerCombustible.selectedItemId

                val car = Car(name, surname, anioMatricula, matricula, autonomia, tipoCombustible)

                if (name.isEmpty() || surname.isEmpty() || matricula.isEmpty() || anioMatricula == 0) {
                    Snackbar.make(binding.root, "Faltan datos por rellenar", Snackbar.LENGTH_LONG)
                        .show()
                    return
                }
                val intent = Intent(this, ResultActivity::class.java).apply {
                    putExtra("name", name)
                    putExtra("surname", surname)
                    putExtra("matricula", matricula)
                    putExtra("anioMatricula", anioMatricula)
                    putExtra("autonomia", autonomia)
                    putExtra("tipoCombustible", tipoCombustible)


                }
                startActivity(intent)
            }

        }
    }

    private fun spinnerAdapter() {
        val spinner: Spinner = findViewById(R.id.spinnerCombustible)
        val listCombustible = Fuel.getFuelList()
        val adapter = FuelAdapter(this, listCombustible)
        spinner.adapter = adapter
    }
}