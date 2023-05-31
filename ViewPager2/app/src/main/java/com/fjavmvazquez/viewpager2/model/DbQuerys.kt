package com.fjavmvazquez.viewpager2.model

object DbQuerys {
    fun QueryCreateTable(): String {
        return ("CREATE TABLE" + DbUtilitis.DATABASE_NAME + DbUtilitis.ID_NOTA + DbUtilitis.TITULO_NOTA
                + DbUtilitis.FECHA_NOTA + DbUtilitis.DESCRIPTION_NOTA + DbUtilitis.CREATE_AT)
    }
}