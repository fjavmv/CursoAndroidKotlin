package com.example.actionbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.Placeholder

class MainActivity : AppCompatActivity() {

    private lateinit var edtValor1: EditText
    private lateinit var edtValor2: EditText
    private lateinit var btnCalcular: Button
    private lateinit var txtResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        btnCalcular.setOnClickListener {
            txtResultado.text = multiplicar().toString()
            display(multiplicar().toString())
        }

    }


    private fun multiplicar(): Double{
        val dato1 = edtValor1.text.toString().toDouble()
        val dato2 = edtValor2.text.toString().toDouble()
        return  dato1 * dato2
    }

    private fun initControl(){
        edtValor1 = findViewById(R.id.edtVal1)
        edtValor2 = findViewById(R.id.edtVal2)
        btnCalcular = findViewById(R.id.btnCalcular)
        txtResultado = findViewById(R.id.txtResultado)
    }

    private fun display(data: String){
        Toast.makeText(this,data,Toast.LENGTH_SHORT).show()
    }

}