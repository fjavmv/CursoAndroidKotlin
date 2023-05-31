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
import com.fjavmvazquez.viewpager2.adapter.NuevaNotaAdapter.ViewHolderDatos
import com.fjavmvazquez.viewpager2.datamodel.DataModelNotas

class NuevaNotaAdapter(private var mDataModelNotas: ArrayList<DataModelNotas>) : RecyclerView.Adapter<ViewHolderDatos>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatos {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_item_custom, parent, false)
        return ViewHolderDatos(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatos, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolderDatos
        //holder.asignarDatos(articulos.get(position));
        holder.asignarDatos(mDataModelNotas[position])
    }

    override fun getItemCount(): Int {
        //retorna el tamaño de la lista
        return mDataModelNotas.size
    }

    inner class ViewHolderDatos(itemView: View) : RecyclerView.ViewHolder(itemView) {
       lateinit var mTextViewTitulo: TextView
        lateinit var mTextViewDescripcion: TextView
        lateinit var mTextViewFecha: TextView
       lateinit var mImageViewFondo: ImageView
       lateinit var mImageViewFavorito: ImageView
       lateinit var mImageViewCompartir: ImageView
        lateinit var mCardViewListener: CardView

        init {
            inicializaComponentes(itemView)
            mCardViewListener.setOnClickListener { view ->
                Toast.makeText(
                    view.context,
                    mTextViewTitulo.text,
                    Toast.LENGTH_SHORT
                ).show()
            }
            mImageViewCompartir.setOnClickListener { view ->
                Toast.makeText(
                    view.context,
                    "Compartir",
                    Toast.LENGTH_SHORT
                ).show()
            }
            mImageViewFavorito.setOnClickListener { view ->
                Toast.makeText(
                    view.context,
                    "Favoritos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        fun inicializaComponentes(itemView: View) {
            mTextViewTitulo = itemView.findViewById(R.id.txtTitulo)
            mImageViewFondo = itemView.findViewById(R.id.imgvFondo)
            mImageViewFavorito = itemView.findViewById(R.id.imgvFavorito)
            mImageViewCompartir = itemView.findViewById(R.id.imgCompartir)
            mTextViewDescripcion = itemView.findViewById(R.id.txtContenido)
            mTextViewFecha = itemView.findViewById(R.id.txtFecha)
            mCardViewListener = itemView.findViewById(R.id.cardViewListener)
        }

        fun asignarDatos(dataModelNotas: DataModelNotas) {
            mImageViewFondo.setImageResource(dataModelNotas.idFoto)
            mTextViewTitulo.text = dataModelNotas.titulo
            mTextViewDescripcion.text = dataModelNotas.descripcion
            mTextViewFecha.text = dataModelNotas.fecha
        }
    }
}