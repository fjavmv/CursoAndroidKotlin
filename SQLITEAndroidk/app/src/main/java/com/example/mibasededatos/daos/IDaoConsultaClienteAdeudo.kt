package com.example.mibasededatos.daos

import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto

interface IDaoConsultaClienteAdeudo {
    fun consultarAdeudosClientes(): ArrayList<ConsultaClienteAdeudoDto>
}