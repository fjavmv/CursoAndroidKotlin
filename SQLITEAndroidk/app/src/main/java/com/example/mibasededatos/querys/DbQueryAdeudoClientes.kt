package com.example.mibasededatos.querys

object DbQueryAdeudoClientes {
    var CONSULTA_ADEUDO_CLIENTES = """SELECT 
nombre_cliente,
apellido_paterno,
	apellido_materno,
	tipo_adeudo,
	monto_adeudo,
	fecha_adeudo
FROM 
    clientes
INNER JOIN adeudos_de_clientes USING(id_cliente) WHERE estado_adeudo = 'Pendiente de pago';"""
}