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
    private lateinit var edtId: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnConsultar: Button
    private lateinit var btnActualizar: Button
    private lateinit var btnEliminar: Button
    private lateinit var btnConsulataNombre: Button
    private lateinit var presenter: IOperacionesPresenter
    private var userDto = UserDto()
    private var result = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicializamos controles de la vista
        initControl()
        //Invocamos al méotodo para su ejecución
        insertElement()
        selectUserName()
        selectUserId()
        updateUser()

    }

    //Pasa los datos d ela vista al presentador
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

    //Recuperamos el resultado de la inserción de elementos
    override fun showResultInsert(result: Int) {
        this.result = result
    }

    override fun selectUserName() {
        btnConsulataNombre.setOnClickListener {
            val name = edtNombre.text.toString()
            presenter.selectUserName(name)
            edtNombre.setText(userDto.name)
            edtApellido.setText(userDto.lastName)
            edtTelefono.setText(userDto.phoneNumber)
            edtEmail.setText(userDto.userEmail)
        }
    }

    override fun showResulSelect(userDto: UserDto) {
        this.userDto = userDto
        println(userDto.lastName)
        print(userDto.lastName)
    }

    override fun selectUserId() {
        btnConsultar.setOnClickListener {
            val id = edtId.text.toString().toInt()
            presenter.selectUserId(id)
            edtNombre.setText(userDto.name)
            edtApellido.setText(userDto.lastName)
            edtTelefono.setText(userDto.phoneNumber)
            edtEmail.setText(userDto.userEmail)
        }
    }

    override fun showResultSelectId(userDto: UserDto) {
        this.userDto = userDto
    }

    override fun updateUser() {
        btnActualizar.setOnClickListener {
            presenter.updateUser(leerDatos())
            limpiar()
            if (result!=-1)
            {
                display("Se ha actualizado el registro $result")
            }else{
                display("No se ha realizado la actualización $result")
            }
        }
    }

    override fun showResultUpdate(result: Int) {
        this.result = result
    }

    private fun initControl() {
        edtNombre = findViewById(R.id.edtNombre)
        edtApellido = findViewById(R.id.edtApellido)
        edtTelefono = findViewById(R.id.edtTelefono)
        edtEmail = findViewById(R.id.edtCorreo)
        btnGuardar = findViewById(R.id.btnGuardar)
        edtId = findViewById(R.id.edtId)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnConsultar = findViewById(R.id.btnConsultar)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnConsulataNombre = findViewById(R.id.btnConsultarNombre)
        presenter = OperacionesPresenterImpl(this, this.applicationContext)
    }

    private fun leerDatos(): UserDto {
        val id = edtId.text.toString()
        val nombre = edtNombre.text.toString()
        val apellido = edtApellido.text.toString()
        val telefono = edtTelefono.text.toString()
        val email = edtEmail.text.toString()
        return UserDto(id.toLong(),nombre, apellido, telefono, email)
    }

    private fun display(dato: String) {
        Toast.makeText(this, dato, Toast.LENGTH_SHORT).show()
    }

    private fun limpiar() {
        edtNombre.setText(" ")
        edtApellido.setText(" ")
        edtTelefono.setText(" ")
        edtEmail.setText(" ")
    }

}