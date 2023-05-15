package com.example.mibasededatos.querys

object DbQuerysCliente {
    var DATABASE_VERSION = 1
    var DATABASE_NAME = "control_adeudos.db"
    const val TABLE_CLIENTES = "CREATE TABLE \"clientes\" (\n" +
            "\t\"id_cliente\"\tINTEGER NOT NULL UNIQUE,\n" +
            "\t\"nombre_cliente\"\tTEXT NOT NULL,\n" +
            "\t\"apellido_paterno\"\tTEXT NOT NULL,\n" +
            "\t\"apellido_materno\"\tTEXT NOT NULL,\n" +
            "\tCONSTRAINT \"pk_id_cliente\" PRIMARY KEY(\"id_cliente\" AUTOINCREMENT)\n" +
            ");"
    var ELIMINAR_TABLA_CLIENTES = "DROP TABLE clientes;"
    var TABLE_CLIENTES_NAME = "clientes"
    var CONSULTAR_CLIENTES =
        "SELECT id_cliente, nombre_cliente, apellido_paterno, apellido_materno FROM clientes ORDER BY id_cliente ASC;" //public static String CONSULTAR_POR_NOMBRE = "SELECT id_nombre FROM clientes WHERE nombre_cliente = ? AND apellido_apaterno = ? AND appellido_materno = ? LIMIT 1;";
}