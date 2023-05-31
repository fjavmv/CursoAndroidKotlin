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
import com.fjavmvazquez.viewpager2.adapter.AdapterHome.ViewHolderDatosHome
import com.fjavmvazquez.viewpager2.datamodel.DataModelHome

class AdapterHome(private var mDataModelHome: ArrayList<DataModelHome>) : RecyclerView.Adapter<ViewHolderDatosHome>() {
    //lateinit var home: DataModelHome

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderDatosHome {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_presupuesto, parent, false)
        return ViewHolderDatosHome(view)
    }

    override fun onBindViewHolder(holder: ViewHolderDatosHome, position: Int) {
        //Establece la comunicación entre el adaptador y ViewHolderDatosHome
        holder.asignarDatos(mDataModelHome[position])
    }

    override fun getItemCount(): Int {
        return mDataModelHome.size
    }

    inner class ViewHolderDatosHome(itemView: View) : RecyclerView.ViewHolder(itemView) {
       lateinit var mTextViewTitulo: TextView
       lateinit var mTextViewMonto: TextView
       lateinit var mImageViewELiminar: ImageView
       lateinit var mCardViewListener: CardView

        init {
            inicializaComponentes(itemView)
            mCardViewListener.setOnClickListener { view -> // Context context = view.getContext();
                // Intent intent = new Intent(view.getContext(), MainActivity.class);
                // context.startActivity(intent);
                Toast.makeText(view.context, "hhhdhdhdhd", Toast.LENGTH_SHORT).show()
            }
        }

        fun inicializaComponentes(itemView: View) {
            mTextViewTitulo = itemView.findViewById(R.id.txtTituloHome)
            mImageViewELiminar = itemView.findViewById(R.id.imgEliminar)
            mTextViewMonto = itemView.findViewById(R.id.txtMonto)
            mCardViewListener = itemView.findViewById(R.id.cardViewListenerHome)
        }

        fun asignarDatos(dataModelHOme: DataModelHome) {
            mTextViewTitulo.text = dataModelHOme.titulo
            mTextViewMonto.text = dataModelHOme.monto.toString()
        }
    }
}