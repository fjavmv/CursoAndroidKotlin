package com.example.mibasededatos.view

import com.example.mibasededatos.entidades.AdeudoDto
import com.example.mibasededatos.entidades.ClienteDto

interface IAdeudoActivityVIew {
    fun registrarNuevoAdeudo(adeudoDto: AdeudoDto): Long
    fun consultarCLientes(): ArrayList<ClienteDto>
    fun construirRecyclerElementos()
}