package com.example.controlspinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ArrayAdapter.createFromResource
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var edtValor1: EditText
    private lateinit var edtValor2: EditText
    private lateinit var spOperaciones: Spinner
    private lateinit var txtResultado: TextView
    private lateinit var btnResultado: Button
    private val operaciones = Operaciones()
    private val loperaciones = arrayOf("Sumar","Restar","Multiplicar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        spOperaciones.adapter = adapterList(loperaciones)
        opciones(spOperaciones)

    }
    private fun initControl() {
        edtValor1 = findViewById(R.id.edtVal1)
        edtValor2 = findViewById(R.id.edtVal2)
        spOperaciones = findViewById(R.id.spOperaciones)
        txtResultado = findViewById(R.id.txtResultado)
        btnResultado = findViewById(R.id.btnCalcular)
    }

    private fun adapterList(lista: Array<String>): ArrayAdapter<CharSequence> { //Aqui retornarias ArrayAdapter<String>
        //utilizando array definido desde código
        //val adapter =  ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
        //Si quereos utilizar recursos desde un archivo string
         val adapter = createFromResource(this,R.array.operaciones,android.R.layout.simple_spinner_item)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        return adapter
    }

    private fun opciones(spinner: Spinner){
        btnResultado.setOnClickListener {
            val val1 = edtValor1.text.toString().toDouble()
            val val2 = edtValor2.text.toString().toDouble()
            when(spinner.selectedItem.toString()){
                "Sumar" ->{
                    txtResultado.text = operaciones.sumar(val1,val2).toString()
                }
                "Restar" ->{
                    txtResultado.text = operaciones.restar(val1,val2).toString()
                }
                "Multiplicar" ->{
                    txtResultado.text = operaciones.multiplicar(val1,val2).toString()
                }
                else ->{
                    Log.i("Opción","Opción invalida")
                }
            }
        }
    }

}