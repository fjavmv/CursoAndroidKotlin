package com.example.mibasededatos.openHelperDb

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mibasededatos.querys.DbQuerysAdeudo
import com.example.mibasededatos.querys.DbQuerysCliente
import com.example.mibasededatos.querys.DbQuerysCorreo
import com.example.mibasededatos.querys.DbQuerysTelefono

open class DbHelper(context: Context?) : SQLiteOpenHelper(
    context,
    DbQuerysCliente.DATABASE_NAME,
    null,
    DbQuerysCliente.DATABASE_VERSION
) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        sqLiteDatabase.execSQL(DbQuerysCliente.TABLE_CLIENTES)
        sqLiteDatabase.execSQL(DbQuerysCorreo.TABLE_CORREOS_CLIENTES)
        sqLiteDatabase.execSQL(DbQuerysTelefono.TABLE_NUMEROS_TELEFONO_CLIENTES)
        sqLiteDatabase.execSQL(DbQuerysAdeudo.TABLE_ADEUDOS_CLIENTES)
    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, i: Int, i1: Int) {
        sqLiteDatabase.execSQL(DbQuerysCliente.ELIMINAR_TABLA_CLIENTES)
        sqLiteDatabase.execSQL(DbQuerysCorreo.ELIMINAR_TABLA_CORREOS)
        sqLiteDatabase.execSQL(DbQuerysTelefono.ELIMINAR_TABLA_TELEFONOS)
        sqLiteDatabase.execSQL(DbQuerysAdeudo.ELIMINAR_TABLA_ADEUDOS)
    }
}