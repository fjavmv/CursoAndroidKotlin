package com.example.mibasededatos.querys

object DbQuerysAdeudo {
    const val TABLE_ADEUDOS_CLIENTES = "CREATE TABLE \"adeudos_de_clientes\" (\n" +
            "\t\"id_edeudo\"\tINTEGER NOT NULL UNIQUE,\n" +
            "\t\"id_cliente\"\tINTEGER NOT NULL,\n" +
            "\t\"tipo_adeudo\"\tTEXT NOT NULL,\n" +
            "\t\"monto_adeudo\"\tREAL NOT NULL,\n" +
            "\t\"fecha_adeudo\"\tTEXT NOT NULL,\n" +
            "\t\"estado_adeudo\"\tTEXT NOT NULL,\n" +
            "\t\"descripcion\"\tTEXT,\n" +
            "\t\"update_at\"\tNUMERIC NOT NULL,\n" +
            "\tFOREIGN KEY(\"id_cliente\") REFERENCES \"clientes\"(\"id_cliente\"),\n" +
            "\tCONSTRAINT \"pk_id_adeudo\" PRIMARY KEY(\"id_edeudo\" AUTOINCREMENT)\n" +
            ");"
    var ELIMINAR_TABLA_ADEUDOS = "DROP TABLE adeudos_de_clientes;"
    var TABLE_NAME_ADEUDOS =
        "adeudos_de_clientes" //public static String UPDATE_AT = "DATETIME('now');";
}