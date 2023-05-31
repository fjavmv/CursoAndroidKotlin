package com.fjavmvazquez.viewpager2.model

object DbUtilitis {
    const val DATABASE_VERSION = 1
    const val DATABASE_NAME = "notas_db"
    const val TABLE_NAME = "tb_notas"
    const val ID_NOTA = "(id_nota INTEGER PRIMARY KEY AUTOINCREMENT,"
    const val TITULO_NOTA = "titulo_nota TEXT NOT NULL,"
    const val FECHA_NOTA = "fecha_nota TEXT NOT NULL,"
    const val DESCRIPTION_NOTA = "description_nota TEXT NOT NULL,"
    const val CREATE_AT = "create_at DATE NOT NULL)"
}