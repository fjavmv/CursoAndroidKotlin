package com.example.mibasededatos.view

import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto

interface IConsultarActivity {
    fun consultarAdeudosClientes(): ArrayList<ConsultaClienteAdeudoDto>
    fun construirRecyclerElementos()
}