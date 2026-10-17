package com.example.contador

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.contador.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var counter: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initGUI(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        actions()

    }

    private fun initGUI(state: Bundle?) {
        counter = state?.getInt("counter") ?:0
        binding.textCounter.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter",counter)
    }

    private fun actions(){
        binding.buttonInc.setOnClickListener(this)
        binding.buttonDec.setOnClickListener(this)
        binding.buttonRes?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when(v!!.id){
            binding.buttonRes?.id -> counter = 0
            binding.buttonInc.id ->{
                if (counter == 15){
                    Snackbar.make(binding.root, "Stepan, "+resources.getString(R.string.message_max), Snackbar.LENGTH_LONG).show()
                } else {
                    counter++
                }

            }
            binding.buttonDec.id ->{
                counter--
            }

        }
        binding.textCounter.setText(counter.toString())

    }

}