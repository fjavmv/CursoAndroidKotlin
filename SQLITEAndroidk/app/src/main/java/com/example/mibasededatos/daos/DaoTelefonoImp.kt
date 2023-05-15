package com.example.mibasededatos.daos

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import com.example.mibasededatos.entidades.TelefonoDto
import com.example.mibasededatos.openHelperDb.DbHelper
import com.example.mibasededatos.querys.DbQuerysTelefono

class DaoTelefonoImp(private val context: Context) : DbHelper(
    context
), IDaoTelefono {
    override fun registrarNuevoTelefono(telefonoDto: TelefonoDto): Long {
        var id: Long = 0
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("numero_telefono", telefonoDto.telefono)
            values.put("id_cliente", telefonoDto.idCliente)
            id = db.insert(DbQuerysTelefono.TABLE_TELEFONO_NAME, null, values)
        } catch (ex: Exception) {
            Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
        return id
    }
}