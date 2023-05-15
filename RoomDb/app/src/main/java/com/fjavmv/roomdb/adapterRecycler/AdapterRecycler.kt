package com.fjavmv.roomdb.adapterRecycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fjavmv.roomdb.R
import com.fjavmv.roomdb.entidad.User

class AdapterRecycler(private val listUser:List<User>): RecyclerView.Adapter<AdapterRecycler.ViewHolderUser>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user,null,false)
        return ViewHolderUser(view)
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        holder.asignarDatos(listUser[position])
    }

    override fun getItemCount(): Int {
       return listUser.size
    }

    class ViewHolderUser(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var edtNombre: TextView
        private var edtApellido: TextView
        private var edtEdad: TextView

        init {
            edtNombre = itemView.findViewById(R.id.txtNombre)
            edtApellido = itemView.findViewById(R.id.txtApellido)
            edtEdad = itemView.findViewById(R.id.txtEdad)
        }

        fun asignarDatos(user: User){
            edtNombre.text = user.firstName
            edtApellido.text = user.lastName
            edtEdad.text = user.age
        }
    }
}