package com.example.mibasededatos.daos

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import com.example.mibasededatos.entidades.ClienteDto
import com.example.mibasededatos.openHelperDb.DbHelper
import com.example.mibasededatos.querys.DbQuerysCliente

class DaoClienteImp(private val context: Context) : DbHelper(
    context
), IDaoCliente {
    override fun registrarNuevoCLiente(cliente: ClienteDto): Long {
        var id: Long = 0
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("nombre_cliente", cliente.nombre)
            values.put("apellido_paterno", cliente.apellidoPaterno)
            values.put("apellido_materno", cliente.apellidoMaterno)
            id = db.insert(DbQuerysCliente.TABLE_CLIENTES_NAME, null, values)
        } catch (ex: Exception) {
            Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
        return id
    }

    @SuppressLint("Recycle")
    override fun consultarCLientes(): ArrayList<ClienteDto> {
        val listaClienteDtos = ArrayList<ClienteDto>()
        val dbHelper = DbHelper(context)
        val db = dbHelper.readableDatabase
        var clienteDto: ClienteDto
        val cursorClientes= db.rawQuery(DbQuerysCliente.CONSULTAR_CLIENTES, null)
        // if (cursorClientes.moveToFirst()){}
        while (cursorClientes.moveToNext()) {
            clienteDto = ClienteDto(
                cursorClientes.getInt(0).toLong(),
                cursorClientes.getString(1),
                cursorClientes.getString(2),
                cursorClientes.getString(3)
            )
            listaClienteDtos.add(clienteDto)
        }
        return listaClienteDtos
    }
}