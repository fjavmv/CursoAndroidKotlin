package com.example.controlcheckbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var edtValor1: EditText
    private lateinit var edtValor2: EditText
    private lateinit var chSumar: CheckBox
    private lateinit var chRestar: CheckBox
    private lateinit var chMultiplicar: CheckBox
    private lateinit var txtResultado: TextView
    private lateinit var btnResultado: Button
    private val operaciones = Operaciones()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        btnResultado.setOnClickListener {
            val val1: Double = edtValor1.text.toString().toDouble()
            val val2: Double = edtValor2.text.toString().toDouble()
            opciones(val1, val2)
        }

    }

    private fun initControl() {
        edtValor1 = findViewById(R.id.edtVal1)
        edtValor2 = findViewById(R.id.edtVal2)
        chSumar = findViewById(R.id.chSumar)
        chRestar = findViewById(R.id.chRestar)
        chMultiplicar = findViewById(R.id.chMultiplicar)
        txtResultado = findViewById(R.id.txtResultado)
        btnResultado = findViewById(R.id.btnCalcular)
    }

    fun opciones(val1: Double, val2: Double){
        var result = " "
        if (chSumar.isChecked) {
           result = " Suma: ${operaciones.sumar(val1, val2)}"
        }
        if (chRestar.isChecked) {
            result += " Resta: ${operaciones.restar(val1, val2)}"
        }
        if (chMultiplicar.isChecked){
           result += " Multilicación: ${operaciones.multiplicar(val1, val2)}"
        }
        txtResultado.text = result
    }

}