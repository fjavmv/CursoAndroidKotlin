package com.example.dbuser.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.dbuser.R
import com.example.dbuser.dataModel.UserDto
import com.example.dbuser.interfaces.IOperacionesPresenter
import com.example.dbuser.interfaces.IOperacionesView
import com.example.dbuser.presenter.OperacionesPresenterImpl

class MainActivity : AppCompatActivity(), IOperacionesView {

    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtTelefono: EditText
    private lateinit var edtEmail: EditText
    private lateinit var btnGuardar: Button
    private lateinit var presenter: IOperacionesPresenter
    private var result = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
    }

    private fun leerDatos(): UserDto {
        val nombre = edtNombre.text.toString()
        val apellido = edtApellido.text.toString()
        val telefono = edtTelefono.text.toString()
        val email = edtEmail.text.toString()
        return UserDto(nombre, apellido, telefono, email)
    }

    private fun initControl() {
        edtNombre = findViewById(R.id.edtNombre)
        edtApellido = findViewById(R.id.edtApellido)
        edtTelefono = findViewById(R.id.edtTelefono)
        edtEmail = findViewById(R.id.edtCorreo)
        btnGuardar = findViewById(R.id.btnGuardar)
        presenter = OperacionesPresenterImpl(this, this.applicationContext)
    }

    private fun limpiar() {
        edtNombre.setText(" ")
        edtApellido.setText(" ")
        edtTelefono.setText(" ")
        edtEmail.setText(" ")
    }

    override fun insertElement() {
        btnGuardar.setOnClickListener {
            //Pamos los datos leidos desde la vista al presentador
            presenter.insertUser(leerDatos())
            limpiar()
            if (result != -1) {
                display("Datos insertados correctamente $result")
            } else {
                display("No se ha posido insertar el elemento $result")
            }
        }
    }

    //Recuperamos el rsultado de la inserción de elementos
    override fun showResultInsert(result: Int) {
        this.result = result
    }

    private fun display(dato: String) {
        Toast.makeText(this, dato, Toast.LENGTH_SHORT).show()
    }

}