package com.example.mibasededatos.touchHelper

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto

class RecyclerTouchHelper(
    dragDirs: Int,
    swipeDirs: Int,
    private val lista: ArrayList<ConsultaClienteAdeudoDto>
) : ItemTouchHelper.SimpleCallback(dragDirs, swipeDirs) {
    private val adapterConsultaClienteAdeudo: AdapterConsultaClienteAdeudo? = null
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        lista.removeAt(viewHolder.adapterPosition)
        adapterConsultaClienteAdeudo!!.notifyItemRemoved(viewHolder.adapterPosition)
    }
}