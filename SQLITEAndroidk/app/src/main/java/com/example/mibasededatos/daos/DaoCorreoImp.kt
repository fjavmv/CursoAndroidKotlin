package com.example.mibasededatos.daos

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import com.example.mibasededatos.entidades.CorreoDto
import com.example.mibasededatos.openHelperDb.DbHelper
import com.example.mibasededatos.querys.DbQuerysCorreo

class DaoCorreoImp(private val context: Context) : DbHelper(
    context
), IDaoCorreo {
    override fun registrarNuevoCorreo(correoDto: CorreoDto): Long {
        var id: Long = 0
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("correo_cliente", correoDto.correo)
            values.put("id_cliente", correoDto.idCLiente)
            id = db.insert(DbQuerysCorreo.TABLE_CORREOS_NAME, null, values)
        } catch (ex: Exception) {
            Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
        return id
    }
}