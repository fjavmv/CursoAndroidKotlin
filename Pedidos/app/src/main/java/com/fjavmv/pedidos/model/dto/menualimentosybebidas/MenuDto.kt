package com.fjavmv.pedidos.model.dto.menualimentosybebidas

data class MenuDto(var name: String, var type: String, var size: String, var description: String, var cost: Double){

    constructor():this(" "," "," "," ",0.0)

}

