package com.example.mibasededatos.daos

import com.example.mibasededatos.entidades.TelefonoDto

interface IDaoTelefono {
    fun registrarNuevoTelefono(telefonoDto: TelefonoDto): Long
}