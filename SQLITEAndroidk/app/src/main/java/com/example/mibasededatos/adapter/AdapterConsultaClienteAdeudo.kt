package com.example.mibasededatos.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.mibasededatos.R
import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo.ViewHolderDatosConsulta
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto

class AdapterConsultaClienteAdeudo(var consultaClienteAdeudoDtos: ArrayList<ConsultaClienteAdeudoDto>) : RecyclerView.Adapter<ViewHolderDatosConsulta>() {

    @SuppressLint("InflateParams")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatosConsulta {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_consulta_adeudos, null, false)
        return ViewHolderDatosConsulta(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatosConsulta, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolderDatosHome
        holder.asignarDatos(consultaClienteAdeudoDtos[position])
    }

    override fun getItemCount(): Int {
        return consultaClienteAdeudoDtos.size
    }

    inner class ViewHolderDatosConsulta(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var textViewNombreCLiente: TextView
        private lateinit var textViewTipoAdeudo: TextView
        private lateinit var textVieMonto: TextView
        private lateinit var textVieFechaAdeudo: TextView
        private lateinit var mCardViewListenerConsulta: CardView

        init {
            inicializaComponentes(itemView)
            mCardViewListenerConsulta.setOnClickListener { view ->
                Toast.makeText(view.context, "Selecionado", Toast.LENGTH_SHORT).show()
            }
        }

     private fun inicializaComponentes(itemView: View) {
            textViewNombreCLiente = itemView.findViewById(R.id.txtNombreCLiente)
            textViewTipoAdeudo = itemView.findViewById(R.id.txtTipoAdeudo)
            textVieMonto = itemView.findViewById(R.id.txtPrecio)
            textVieFechaAdeudo = itemView.findViewById(R.id.txtFechaAdeudo)
            mCardViewListenerConsulta = itemView.findViewById(R.id.cardViewListenerConsulta)
        }

        fun asignarDatos(consultaClienteAdeudoDto: ConsultaClienteAdeudoDto) {
            val nombreCompleto = consultaClienteAdeudoDto.nombreCLiente+ " " + consultaClienteAdeudoDto.apellidoP + " " + consultaClienteAdeudoDto.apellidoM
            val precio = "$ " + consultaClienteAdeudoDto.precio
            textViewNombreCLiente.text = nombreCompleto
            textViewTipoAdeudo.text = consultaClienteAdeudoDto.tipoDeAdeudo
            textVieMonto.text = precio
            textVieFechaAdeudo.text = consultaClienteAdeudoDto.fecha
        }
    }
}