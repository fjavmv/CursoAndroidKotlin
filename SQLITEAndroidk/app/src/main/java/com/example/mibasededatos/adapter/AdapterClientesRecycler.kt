package com.example.mibasededatos.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mibasededatos.R
import com.example.mibasededatos.adapter.AdapterClientesRecycler.ViewHolderDatosClientes
import com.example.mibasededatos.entidades.ClienteDto

class AdapterClientesRecycler(private val listaCLientes: ArrayList<ClienteDto>) :
    RecyclerView.Adapter<ViewHolderDatosClientes>(), View.OnClickListener {

    private lateinit var listener: View.OnClickListener

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatosClientes {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item, null, false)
        view.setOnClickListener(this)
        return ViewHolderDatosClientes(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatosClientes, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        holder.asignarDatos(listaCLientes[position])
    }

    override fun getItemCount(): Int {
        return listaCLientes.size
    }

    fun setOnClickListener(listener: View.OnClickListener?) {
        if (listener != null) {
            this.listener = listener
        }
    }

    override fun onClick(view: View) {
        listener.onClick(view)
    }

    inner class ViewHolderDatosClientes(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dataCLientes: TextView

        init {
            dataCLientes = itemView.findViewById(R.id.txtNombres)
        }

        fun asignarDatos(datos: ClienteDto?) {
            dataCLientes.text = datos.toString()
        }
    }
}