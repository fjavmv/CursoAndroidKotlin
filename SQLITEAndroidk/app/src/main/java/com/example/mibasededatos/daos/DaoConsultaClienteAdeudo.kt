package com.example.mibasededatos.daos

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto
import com.example.mibasededatos.openHelperDb.DbHelper
import com.example.mibasededatos.querys.DbQueryAdeudoClientes

class DaoConsultaClienteAdeudo(private val context: Context) : DbHelper(
    context
), IDaoConsultaClienteAdeudo {
    @SuppressLint("Recycle")
    override fun consultarAdeudosClientes(): ArrayList<ConsultaClienteAdeudoDto> {
        val consultaClienteAdeudoDtos = ArrayList<ConsultaClienteAdeudoDto>()
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.readableDatabase
            var consultaClienteAdeudoDto: ConsultaClienteAdeudoDto
            val cursor = db.rawQuery(DbQueryAdeudoClientes.CONSULTA_ADEUDO_CLIENTES, null)
            while (cursor.moveToNext()) {
                consultaClienteAdeudoDto = ConsultaClienteAdeudoDto(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getString(5)
                )
                consultaClienteAdeudoDtos.add(consultaClienteAdeudoDto)
            }
        } catch (ex: Exception) {
            Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
        return consultaClienteAdeudoDtos
    }
}