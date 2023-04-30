package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast

class Preferencias(private val preferences: SharedPreferences) {

    fun guardarPreferencia(agenda: Agenda) {
        val editor = preferences.edit()
        editor.putString(
            agenda.nombre,
            "Nombre: ${agenda.nombre} \nTelélefono: ${agenda.telefono} \nCorreo: ${agenda.email}"
        )
        editor.commit()
        editor.apply()
    }

    fun consultarPreferencia(dato: String): String? {
        return preferences.getString(dato, "No se encontro el elemento")
    }

}