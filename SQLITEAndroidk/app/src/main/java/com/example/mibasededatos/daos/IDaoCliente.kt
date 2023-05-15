package com.example.mibasededatos.daos

import com.example.mibasededatos.entidades.ClienteDto

interface IDaoCliente {
    fun registrarNuevoCLiente(cliente: ClienteDto): Long
    fun consultarCLientes(): ArrayList<ClienteDto>
}