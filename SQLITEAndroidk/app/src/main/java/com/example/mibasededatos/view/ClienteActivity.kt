package com.example.mibasededatos.view

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mibasededatos.R
import com.example.mibasededatos.daos.DaoClienteImp
import com.example.mibasededatos.daos.DaoCorreoImp
import com.example.mibasededatos.daos.DaoTelefonoImp
import com.example.mibasededatos.daos.IDaoCliente
import com.example.mibasededatos.daos.IDaoCorreo
import com.example.mibasededatos.daos.IDaoTelefono
import com.example.mibasededatos.entidades.ClienteDto
import com.example.mibasededatos.entidades.CorreoDto
import com.example.mibasededatos.entidades.TelefonoDto

class ClienteActivity : AppCompatActivity(), IClienteActivityView {
    private lateinit var nombre: EditText
    private  lateinit var apellidoP: EditText
    private lateinit var apellidoM: EditText
    private lateinit var numeroTel: EditText
    private lateinit var email: EditText
    private lateinit var buttonGuardar: Button
    private lateinit var buttonCancelar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cliente)
        inicializarControles()
        buttonGuardar.setOnClickListener {
            val cliente = ClienteDto(
                nombre.text.toString(),
                apellidoP.text.toString(),
                apellidoM.text.toString()
            )
            val id = registrarNuevoCLiente(cliente)
            cliente.idCliente = id
            val telefonoDto = TelefonoDto(numeroTel.text.toString(), cliente.idCliente)
            val id_tel = registrarNuevoTelefono(telefonoDto)
            val correoDto = CorreoDto(email.text.toString(), cliente.idCliente)
            val id_email = registrarNuevoCorreo(correoDto)
            if (id > 0 && id_tel > 0 && id_email > 0) {
                mostrarToast("Registro almacenado de manera correcta")
            } else {
                mostrarToast("Error al guardar los registros")
            }
            limpiarCampos()
        }
    }

    private fun inicializarControles() {
        nombre = findViewById(R.id.edt_nombre_cliente)
        apellidoP = findViewById(R.id.edt_apellido_paterno_cliente)
        apellidoM = findViewById(R.id.edt_apellido_materno_cliente)
        buttonGuardar = findViewById(R.id.btn_guardar)
        email = findViewById(R.id.edt_correo_cliente)
        numeroTel = findViewById(R.id.edt_numero_telefono_cliente)
    }

    override fun registrarNuevoCLiente(cliente: ClienteDto): Long {
        val iDaoCliente: IDaoCliente = DaoClienteImp(this@ClienteActivity)
        return iDaoCliente.registrarNuevoCLiente(cliente)
    }

    override fun registrarNuevoCorreo(correoDto: CorreoDto): Long {
        val iDaoCorreo: IDaoCorreo = DaoCorreoImp(this@ClienteActivity)
        return iDaoCorreo.registrarNuevoCorreo(correoDto)
    }

    override fun registrarNuevoTelefono(telefonoDto: TelefonoDto): Long {
        val iDaoTelefono: IDaoTelefono = DaoTelefonoImp(this@ClienteActivity)
        return iDaoTelefono.registrarNuevoTelefono(telefonoDto)
    }

    private fun limpiarCampos() {
        nombre.setText("")
        apellidoP.setText("")
        apellidoM.setText("")
        numeroTel.setText("")
        email.setText("")
        nombre.isFocusable = true
    }
    private fun mostrarToast(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }

}