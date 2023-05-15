package com.example.mibasededatos.querys

object DbQuerysCorreo {
    const val TABLE_CORREOS_CLIENTES = "CREATE TABLE \"correos_clientes\" (\n" +
            "\t\"id_email\"\tINTEGER NOT NULL UNIQUE,\n" +
            "\t\"correo_cliente\"\tTEXT UNIQUE,\n" +
            "\t\"id_cliente\"\tINTEGER NOT NULL,\n" +
            "\tCONSTRAINT \"pk_id_email\" PRIMARY KEY(\"id_email\" AUTOINCREMENT),\n" +
            "\tFOREIGN KEY(\"id_cliente\") REFERENCES \"clientes\"(\"id_cliente\")\n" +
            ");"
    var ELIMINAR_TABLA_CORREOS = "DROP TABLE correos_clientes;"
    var TABLE_CORREOS_NAME = "correos_clientes"
}