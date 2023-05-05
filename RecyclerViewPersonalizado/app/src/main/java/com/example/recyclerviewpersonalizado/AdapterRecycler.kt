package com.example.recyclerviewpersonalizado

import android.provider.ContactsContract.CommonDataKinds.Email
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterRecycler(private val listaAgenda: ArrayList<Agenda>): RecyclerView.Adapter<AdapterRecycler.ViewHolderAgenda>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderAgenda {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,null,false)
        return ViewHolderAgenda(view)
    }

    override fun getItemCount(): Int {
        return listaAgenda.size
    }

    override fun onBindViewHolder(holder: ViewHolderAgenda, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolder
        holder.asignarDatos(listaAgenda[position])
    }

    class ViewHolderAgenda (itemView: View): RecyclerView.ViewHolder(itemView) {
        private val txtNombre: TextView
        private val  txtApellido: TextView
        private val  txtPhone: TextView
        private val txtEmail: TextView

        init {
            txtNombre = itemView.findViewById(R.id.txtNombre)
            txtApellido = itemView.findViewById(R.id.txtApellido)
            txtPhone = itemView.findViewById(R.id.txtTelefono)
            txtEmail= itemView.findViewById(R.id.txtEmail)
        }

        fun asignarDatos(datos: Agenda){
            txtNombre.text = datos.nombre
            txtApellido.text = datos.apellido
            txtPhone.text = datos.telefono
            txtEmail.text = datos.email
        }

    }
}