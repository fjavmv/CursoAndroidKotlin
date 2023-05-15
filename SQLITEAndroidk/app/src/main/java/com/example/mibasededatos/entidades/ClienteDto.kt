package com.example.mibasededatos.entidades

data class ClienteDto (var idCliente: Long = 0){
    lateinit var nombre: String
    lateinit var apellidoPaterno: String
    lateinit var apellidoMaterno: String

    constructor(idCliente: Long, nombre: String, apellidoPaterno: String, apellidoMaterno: String): this(idCliente) {
        this.nombre = nombre
        this.apellidoPaterno = apellidoPaterno
        this.apellidoMaterno = apellidoMaterno
    }

    constructor(nombre: String, apellidoPaterno: String, apellidoMaterno: String):this() {
        this.nombre = nombre
        this.apellidoPaterno = apellidoPaterno
        this.apellidoMaterno = apellidoMaterno
    }

    override fun toString(): String {
        return "$nombre $apellidoPaterno $apellidoMaterno"
    }
}