package com.example.mibasededatos.entidades

data class ConsultaClienteAdeudoDto(
    val nombreCLiente: String,
    val apellidoP: String,
    val apellidoM: String,
    val tipoDeAdeudo: String,
    val precio: Int,
    val fecha: String
) {

    override fun toString(): String {
        return nombreCLiente + " " + apellidoP + " " + apellidoM + " " + tipoDeAdeudo + '\'' +
                " " + precio +
                " " + fecha
    }
}