package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editName: EditText
    private lateinit var botonSaludar: Button
    private lateinit var botonVaciar: Button
    private lateinit var botonSalir: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //editName = this.findViewById(R.id.edirNombre)

        }

}

