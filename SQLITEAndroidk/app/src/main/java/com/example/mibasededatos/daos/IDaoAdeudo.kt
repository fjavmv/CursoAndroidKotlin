package com.example.mibasededatos.daos

import com.example.mibasededatos.entidades.AdeudoDto

interface IDaoAdeudo {
    fun registrarNuevoAdeudo(adeudoDto: AdeudoDto): Long
}