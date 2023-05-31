package com.fjavmvazquez.viewpager2.datamodel

class DataModelNotas {
    var idFoto = 0
        private set
    var titulo: String
        private set
    var descripcion: String? = null
        private set
    var fecha: String
        private set

    constructor(idFoto: Int, titulo: String, descripcion: String?, fecha: String) {
        this.idFoto = idFoto
        this.titulo = titulo
        this.descripcion = descripcion
        this.fecha = fecha
    }

    constructor(titulo: String, fecha: String) {
        this.titulo = titulo
        this.fecha = fecha
    }
}