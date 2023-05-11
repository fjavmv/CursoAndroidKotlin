package com.fjavmv.pedidos.model.dto.pedidodto

data class PedidoDto(var numeroPedido: Int, var pedido: String, var cantidad: Int, var descripcion: String, var precio: Double){

    constructor():this(0," ",0,"",0.0)

    override fun toString(): String {
        return "$numeroPedido $pedido $cantidad $descripcion $precio"
    }
}
