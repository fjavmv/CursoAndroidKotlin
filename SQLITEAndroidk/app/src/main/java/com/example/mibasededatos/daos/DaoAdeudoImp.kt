package com.example.mibasededatos.daos

import android.content.ContentValues
import android.content.Context
import android.widget.Toast
import com.example.mibasededatos.entidades.AdeudoDto
import com.example.mibasededatos.openHelperDb.DbHelper
import com.example.mibasededatos.querys.DbQuerysAdeudo

class DaoAdeudoImp(var context: Context) : DbHelper(context), IDaoAdeudo {
    override fun registrarNuevoAdeudo(adeudoDto: AdeudoDto): Long {
        var id: Long = 0
        try {
            val dbHelper = DbHelper(context)
            val db = dbHelper.writableDatabase
            val values = ContentValues()
            values.put("id_cliente", adeudoDto.idCLiente)
            values.put("tipo_adeudo", adeudoDto.tipoAdeudo)
            values.put("monto_adeudo", adeudoDto.montoAdeudo)
            values.put("fecha_adeudo", adeudoDto.fechaAdeudo)
            values.put("estado_adeudo", adeudoDto.estadoAdeudo)
            values.put("descripcion", adeudoDto.descripcion)
            values.put("update_at", adeudoDto.updateAt)
            id = db.insert(DbQuerysAdeudo.TABLE_NAME_ADEUDOS, null, values)
        } catch (ex: Exception) {
            Toast.makeText(context.applicationContext, ex.message, Toast.LENGTH_SHORT).show()
        }
        return id
    }
}