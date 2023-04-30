package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtEmail: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRecuperar: Button
    private lateinit var txtMostrar: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        //Obtenemos una referencia de un objeto de la clase SharedPreferences
        //El primer parámetro es el nombre del archivo
        //segundo la forma de creación del archivo (MODE_PRIVATE indica que solo esta aplicación puede consultar el archivo
        val preferen = getSharedPreferences(
            resources.getString(R.string.key_sharedpreferen_name),
            Context.MODE_PRIVATE
        )
        //Inyectamos una dependecia
        val preferencias = Preferencias(preferen)

        btnGuardar.setOnClickListener {
            preferencias.guardarPreferencia(obtenerDatos())
            limpiarCampos()
            display("Se han guardado los elementos")
        }

        btnRecuperar.setOnClickListener {
            if (buscarKey().isEmpty()) {
                display("No se ingresó un valor de búsqueda")
            } else {
                txtMostrar.text = preferencias.consultarPreferencia(buscarKey())
            }

        }
    }

    private fun buscarKey(): String {
        return edtNombre.text.toString()
    }

    private fun initControl() {
        edtNombre = findViewById(R.id.edtNombre)
        edtTelefono = findViewById(R.id.edtTelefono)
        edtEmail = findViewById(R.id.edtEmail)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnRecuperar = findViewById(R.id.btnConsultar)
        txtMostrar = findViewById(R.id.txtDatos)
    }

    private fun obtenerDatos(): Agenda {
        return Agenda(
            edtNombre.text.toString(),
            edtTelefono.text.toString(),
            edtEmail.text.toString()
        )
    }

    private fun limpiarCampos() {
        edtNombre.setText(" ")
        edtTelefono.setText(" ")
        edtEmail.setText(" ")
    }

    private fun display(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}