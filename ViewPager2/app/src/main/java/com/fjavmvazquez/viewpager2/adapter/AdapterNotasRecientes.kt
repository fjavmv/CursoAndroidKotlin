package com.fjavmvazquez.viewpager2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.fjavmvazquez.viewpager2.R
import com.fjavmvazquez.viewpager2.adapter.AdapterNotasRecientes.ViewHolderDatosRecientes
import com.fjavmvazquez.viewpager2.datamodel.DataModelNotas

class AdapterNotasRecientes(var mDataModelNotas: ArrayList<DataModelNotas>) :
    RecyclerView.Adapter<ViewHolderDatosRecientes>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatosRecientes {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_recientes, parent, false)
        return ViewHolderDatosRecientes(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatosRecientes, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        //holder.asignarDatos(articulos.get(position));
        holder.asignarDatos(mDataModelNotas[position])
    }

    override fun getItemCount(): Int {
        //retorna el tamaño de la lista
        return mDataModelNotas.size
    }

    inner class ViewHolderDatosRecientes(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var mTextViewTitulo: TextView
        lateinit var mTextViewFecha: TextView
        lateinit var mImageViewCompartir: ImageView
        lateinit var mCardViewListener: CardView

        init {
            inicializaComponentes(itemView)
            mCardViewListener.setOnClickListener { view ->
                Toast.makeText(view.context, mTextViewTitulo.text, Toast.LENGTH_SHORT).show()
            }
            mImageViewCompartir.setOnClickListener { view ->
                Toast.makeText(
                    view.context,
                    "Compartir",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun inicializaComponentes(itemView: View) {
            mTextViewTitulo = itemView.findViewById(R.id.txtTitulo)
            mImageViewCompartir = itemView.findViewById(R.id.imgCompartir)
            mTextViewFecha = itemView.findViewById(R.id.txtFecha)
            mCardViewListener = itemView.findViewById(R.id.cardViewListener)
        }

        fun asignarDatos(dataModelNotas: DataModelNotas) {
            mTextViewTitulo.text = dataModelNotas.titulo
            mTextViewFecha.text = dataModelNotas.fecha
        }
    }
}