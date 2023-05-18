package com.fjavmv.viewbindingdbroom.adapterRecycler



import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjavmv.viewbindingdbroom.databinding.ListItemUserBinding
import com.fjavmv.viewbindingdbroom.entidad.User

class AdapterRecycler(private val listUser:List<User>): RecyclerView.Adapter<AdapterRecycler.ViewHolderUser>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUser {
        val itemUserBinding = ListItemUserBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolderUser(itemUserBinding)
    }

    override fun onBindViewHolder(holder: ViewHolderUser, position: Int) {
        holder.asignarDatos(listUser[position])
    }

    override fun getItemCount(): Int {
       return listUser.size
    }

    class ViewHolderUser(private var binding: ListItemUserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun asignarDatos(user: User){
            binding.txtNombre.text = user.firstName
            binding.txtApellido.text = user.lastName
            binding.txtEdad.text = user.age
        }
    }
}