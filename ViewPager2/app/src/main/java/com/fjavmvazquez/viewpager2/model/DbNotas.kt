package com.fjavmvazquez.viewpager2.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase.CursorFactory

class DbNotas(
    private val mContext: Context?,
    name: String?,
    factory: CursorFactory?,
    version: Int
) : DbHelper(
    mContext, name, factory, version
) {
    fun crearNota(titulo: String?, fecha: String?, description: String?): Long {
        var id: Long = 0
        try {
            val dbHelper =
                DbHelper(mContext, DbUtilitis.DATABASE_NAME, null, DbUtilitis.DATABASE_VERSION)
            val db = dbHelper.writableDatabase
            val contentValues = ContentValues()
            contentValues.put("titulo_nota", titulo)
            contentValues.put("fecha_nota", fecha)
            contentValues.put("description", description)
            id = db.insert(DbUtilitis.TABLE_NAME, null, contentValues)
        } catch (ex: Exception) {
            ex.toString()
        }
        return id
    }
}