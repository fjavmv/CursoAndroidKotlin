package com.example.mibasededatos.entidades

data class AdeudoDto(var idAdeudo: Long = 0, var idCLiente: Long = 0, var montoAdeudo: Double = 0.0) {
    lateinit  var tipoAdeudo: String
    lateinit  var fechaAdeudo: String
    lateinit  var estadoAdeudo: String
     lateinit var descripcion: String
    lateinit  var updateAt: String

    constructor():this(0,0,0.0)

    constructor(idCLiente: Long, tipoAdeudo: String, montoAdeudo: Double, fechaAdeudo: String,
        estadoAdeudo: String, descripcion: String, updateAt: String) : this(){
        this.idCLiente = idCLiente
        this.tipoAdeudo = tipoAdeudo
        this.montoAdeudo = montoAdeudo
        this.fechaAdeudo = fechaAdeudo
        this.estadoAdeudo = estadoAdeudo
        this.descripcion = descripcion
        this.updateAt = updateAt
    }

    override fun toString(): String {
        return idAdeudo.toString() + " " + idCLiente + " " + tipoAdeudo +
                " " + montoAdeudo + " " + fechaAdeudo + " " + estadoAdeudo + " " + descripcion
    }
}