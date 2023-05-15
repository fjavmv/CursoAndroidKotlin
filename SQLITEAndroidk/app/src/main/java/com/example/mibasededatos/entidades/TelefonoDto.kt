package com.example.mibasededatos.entidades

data class TelefonoDto (var idTelefono: Long = 0,var idCliente: Long = 0){

    lateinit var telefono: String
    constructor(telefono: String, idCliente: Long):this() {
        this.telefono = telefono
        this.idCliente = idCliente
    }

    override fun toString(): String {
        return "Telefono{" +
                "idTelefono=" + idTelefono +
                ", telefono='" + telefono + '\'' +
                ", idCliente=" + idCliente +
                '}'
    }
}