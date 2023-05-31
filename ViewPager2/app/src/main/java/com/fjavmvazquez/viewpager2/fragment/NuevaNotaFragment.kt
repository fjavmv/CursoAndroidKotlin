package com.fjavmvazquez.viewpager2.fragment

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.fjavmvazquez.viewpager2.R
import java.util.Calendar

class NuevaNotaFragment : Fragment(), OnDateSetListener {
    private lateinit var mEditTextTitulo: EditText
    // campo a enlazar con el DatePicker
    private lateinit  var mEditTextFecha: EditText
    private lateinit var mEditTextContenido: EditText

    //private Spinner mSpinnerTipoNota;
    private lateinit var mButtonGuardar: Button
    private lateinit var mButtonCancelar: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_nueva_nota, container, false)
        mEditTextTitulo = rootView.findViewById(R.id.edt_titulo)
        mEditTextFecha = rootView.findViewById(R.id.edt_fecha)
        //mSpinnerTipoNota = rootView.findViewById(R.id.tipo_mensaje);
        mEditTextContenido = rootView.findViewById(R.id.edt_contenido)
        mButtonGuardar = rootView.findViewById(R.id.btn_guardar)
        mButtonCancelar = rootView.findViewById(R.id.btn_cancelar)
        mEditTextFecha.setOnClickListener(View.OnClickListener { mostrarCalendario() })
        return rootView
    }

    private fun mostrarCalendario() {
        val datePickerDialog = DatePickerDialog(this.requireContext(), R.style.DatePickerStyle, this, Calendar.getInstance()[Calendar.YEAR],
            Calendar.getInstance()[Calendar.MONTH],
            Calendar.getInstance()[Calendar.DAY_OF_MONTH]
        )
        datePickerDialog.show()
    }

    override fun onDateSet(datePicker: DatePicker, year: Int, month: Int, dayOfMonth: Int) {
        val date = "$month/$dayOfMonth/$year"
        mEditTextFecha.setText(date)
    }
}