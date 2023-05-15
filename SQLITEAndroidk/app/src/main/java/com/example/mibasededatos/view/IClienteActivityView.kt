package com.example.mibasededatos.view

import com.example.mibasededatos.entidades.ClienteDto
import com.example.mibasededatos.entidades.CorreoDto
import com.example.mibasededatos.entidades.TelefonoDto

interface IClienteActivityView {
    fun registrarNuevoCLiente(cliente: ClienteDto): Long
    fun registrarNuevoCorreo(correoDto: CorreoDto): Long
    fun registrarNuevoTelefono(telefonoDto: TelefonoDto): Long
}