package com.example.sharedpreferences

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import android.widget.Toast

class Preferencias(private val preferences: SharedPreferences){


    fun guardarPreferencia(agenda: Agenda) {
        //Obtenemos una referencia de un objeto de la clase SharedPreferences
        //El primer parámetro es el nombre del archivo
        //segundo la forma de creación del archivo (MODE_PRIVATE indica que solo esta aplicación puede consultar el archivo
        val editor = preferences.edit()
        editor.putStringSet(agenda.nombre, mutableSetOf(agenda.nombre,agenda.telefono,agenda.email))
        //editor.putString("Teléfono", agenda.telefono)
       // editor.putString("Email", agenda.email)
        editor.apply()
       // editor.commit()
    }

    fun consultarPreferencia(dato: String): MutableSet<String>? {
        val nombre = preferences.getStringSet( dato,mutableSetOf("hola"," "," "," "))
        //val telefono = preferences.getString("Teléfono", "No hay teléfonos registrados")
        //val email = preferences.getString("Email", "No hay emails registrados")
        return nombre
    }

}