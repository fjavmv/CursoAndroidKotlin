package com.example.mibasededatos.view.dialog

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.example.mibasededatos.R
import java.util.Calendar

class DatePickerFragment : DialogFragment() {
    private var listener: OnDateSetListener? = null
    private fun setListener(listener: OnDateSetListener) {
        this.listener = listener
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Mostramos al fecha actual en el datePicker
        val c = Calendar.getInstance()
        year = c[Calendar.YEAR]
        month = c[Calendar.MONTH]
        day = c[Calendar.DAY_OF_MONTH]
        return DatePickerDialog(activity!!, R.style.DatePickerStyle, listener, year, month, day)
    }

    companion object {
        var day = 0
        var month = 0
        var year = 0
        fun newInstance(listener: OnDateSetListener): DatePickerFragment {
            val fragment = DatePickerFragment()
            fragment.setListener(listener)
            return fragment
        }
    }
}