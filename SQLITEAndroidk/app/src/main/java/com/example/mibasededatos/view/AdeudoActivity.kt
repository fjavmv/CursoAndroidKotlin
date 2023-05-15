package com.example.mibasededatos.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mibasededatos.R
import com.example.mibasededatos.adapter.AdapterClientesRecycler
import com.example.mibasededatos.daos.DaoAdeudoImp
import com.example.mibasededatos.daos.DaoClienteImp
import com.example.mibasededatos.daos.IDaoAdeudo
import com.example.mibasededatos.daos.IDaoCliente
import com.example.mibasededatos.entidades.AdeudoDto
import com.example.mibasededatos.entidades.ClienteDto
import com.example.mibasededatos.view.dialog.DatePickerFragment

class AdeudoActivity : AppCompatActivity(), IAdeudoActivityVIew {
    private lateinit var editTextTipoDeAdeudo: EditText
    private lateinit var editTextNombreCLiente: EditText
    private lateinit var spinnerEstadoDePago: Spinner
    private lateinit var editTextMontoDeAdeudo: EditText
    private lateinit var editTextFecha: EditText
    private lateinit var editTextDescripcion: EditText
    private lateinit var buttonGuardar: Button
    private lateinit var recyclerViewCLientes: RecyclerView
    private lateinit var listaCLiente: ArrayList<ClienteDto>

    private lateinit var adapterEstadoPago: ArrayAdapter<String>

    private lateinit var estadoPago: Array<String>
    private var id: Long = 0
    private lateinit var estadoAdeudo: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adeudo)
        inicializarControles()
        lanzarDatePicker()
        construirRecyclerElementos()
        adapterEstadoAdeudo()
        getEstadoAdeudo()
        clickGUardar()
    }

    private fun inicializarControles() {
        editTextMontoDeAdeudo = findViewById(R.id.edt_monto_adeudo)
        editTextNombreCLiente = findViewById(R.id.edt_nombre_cliente_adeudo)
        editTextTipoDeAdeudo = findViewById(R.id.edt_tipo_adeudo)
        recyclerViewCLientes = findViewById(R.id.recyclerNombresCLientes)
        spinnerEstadoDePago = findViewById(R.id.spinner_estado_adeudo)
        editTextFecha = findViewById(R.id.edt_fecha_adeudo)
        editTextDescripcion = findViewById(R.id.edt_descripcion)
        buttonGuardar = findViewById(R.id.btn_guardarAdeudo)
    }

    private fun lanzarDatePicker() {
        editTextFecha.setOnClickListener {
            showDatePickerDialog()
        }
    }

    private fun adapterEstadoAdeudo() {
        estadoPago = resources.getStringArray(R.array.estado)
        adapterEstadoPago = ArrayAdapter(this, android.R.layout.simple_spinner_item, estadoPago)
        adapterEstadoPago.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerEstadoDePago.adapter = adapterEstadoPago
    }

    private fun getEstadoAdeudo() {
        spinnerEstadoDePago.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View,
                position: Int,
                l: Long
            ) {
                estadoAdeudo = spinnerEstadoDePago.selectedItem.toString()
                mostrarToast(estadoAdeudo)
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {}
        }
    }

    private fun clickGUardar() {
        buttonGuardar.setOnClickListener {
            val fechaActual =
                twoDigits(DatePickerFragment.day) + "-" + twoDigits(DatePickerFragment.month + 1) + "-" + DatePickerFragment.year
            val adeudoDto = AdeudoDto(
                id,
                editTextTipoDeAdeudo.text.toString(),
                editTextMontoDeAdeudo.text.toString().toDouble(),
                editTextFecha.text.toString(),
                estadoAdeudo,
                editTextDescripcion.text.toString(),
                fechaActual
            )
            val idAdeudo = registrarNuevoAdeudo(adeudoDto)
            if (idAdeudo > 0) {
                mostrarToast("El registro ha sido correcto.")
            } else {
                mostrarToast("Ha ocurrido algun error, verifique no insertar datos repetidos.")
            }
        }
        limpiarCampos()
    }


    private fun twoDigits(n: Int): String {
        return if (n <= 9) "0$n" else n.toString()
    }

    private fun showDatePickerDialog() {
        val newFragment: DatePickerFragment = DatePickerFragment.newInstance { _, year, month, dayOfMonth ->
            val diaSeleccionado =
                twoDigits(dayOfMonth) + "-" + twoDigits(month + 1) + "-" + year
            editTextFecha.setText(diaSeleccionado)
        }
        newFragment.show(this.supportFragmentManager, "datePicker")
    }

    override fun registrarNuevoAdeudo(adeudoDto: AdeudoDto): Long {
        val iDaoAdeudo: IDaoAdeudo = DaoAdeudoImp(this@AdeudoActivity)
        return iDaoAdeudo.registrarNuevoAdeudo(adeudoDto)
    }

    override fun consultarCLientes(): ArrayList<ClienteDto> {
        val listClientes: ArrayList<ClienteDto>
        val iDaoCliente: IDaoCliente = DaoClienteImp(this@AdeudoActivity)
        listClientes = iDaoCliente.consultarCLientes()
        return listClientes
    }

    override fun construirRecyclerElementos() {
        listaCLiente = ArrayList()
        listaCLiente = consultarCLientes()
        recyclerViewCLientes.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapterDatos = AdapterClientesRecycler(listaCLiente)
        adapterDatos.setOnClickListener { view ->
            id = listaCLiente[recyclerViewCLientes.getChildAdapterPosition(view)].idCliente
            editTextNombreCLiente.setText(listaCLiente[id.toInt() - 1].toString())
            mostrarToast("id:$id")
        }
        recyclerViewCLientes.adapter = adapterDatos
    }

    private fun limpiarCampos() {
        editTextNombreCLiente.setText("")
        editTextMontoDeAdeudo.setText("")
        editTextFecha.setText("")
        editTextDescripcion.setText("")
    }

    private fun mostrarToast(mensaje: String) {
        Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
    }
}