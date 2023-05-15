package com.example.mibasededatos.daos

import com.example.mibasededatos.entidades.CorreoDto

interface IDaoCorreo {
    fun registrarNuevoCorreo(correoDto: CorreoDto): Long
}