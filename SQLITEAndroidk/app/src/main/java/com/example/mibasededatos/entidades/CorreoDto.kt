package com.example.mibasededatos.entidades

data class CorreoDto(var idCorreo: Long = 0, var idCLiente: Long = 0) {

    lateinit var correo: String


    constructor(correo: String, idCLiente: Long) : this() {
        this.correo = correo
        this.idCLiente = idCLiente
    }

    override fun toString(): String {
        return "Correo{" +
                "idCorreo=" + idCorreo +
                ", correo='" + correo + '\'' +
                ", idCLiente=" + idCLiente +
                '}'
    }
}