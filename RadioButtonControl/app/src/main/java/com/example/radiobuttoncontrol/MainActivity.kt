package com.example.radiobuttoncontrol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var edtValor1: EditText
    private lateinit var edtValor2: EditText
    private lateinit var rbSumar: RadioButton
    private lateinit var rbRestar: RadioButton
    private lateinit var rbMultiplicar: RadioButton
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

    fun initControl() {
        edtValor1 = findViewById(R.id.edtVal1)
        edtValor2 = findViewById(R.id.edtVal2)
        rbSumar = findViewById(R.id.rbSumar)
        rbRestar = findViewById(R.id.rbRestar)
        rbMultiplicar = findViewById(R.id.rbMultiplicar)
        txtResultado = findViewById(R.id.txtResultado)
        btnResultado = findViewById(R.id.btnCalcular)
    }

    fun opciones(val1: Double, val2: Double) {
        if (rbSumar.isChecked) {

            txtResultado.text = operaciones.sumar(val1, val2).toString()
        } else if (rbRestar.isChecked) {
            txtResultado.text = operaciones.restar(val1, val2).toString()
        } else {
            txtResultado.text = operaciones.multiplicar(val1, val2).toString()
        }
    }


}