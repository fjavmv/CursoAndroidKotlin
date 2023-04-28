package com.example.sharedpreferences

data class Agenda(var nombre:String, var telefono: String, var email: String){
    override fun toString(): String {
        return "Agenda(nombre='$nombre', telefono='$telefono', email='$email')"
    }
}

