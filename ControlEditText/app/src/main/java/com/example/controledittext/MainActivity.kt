package com.example.controledittext

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var edtUser: EditText
    private lateinit var edtPass: EditText
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()

        btnLogin.setOnClickListener {
            val user = edtUser.text.toString()
            val pass = edtPass.text.toString()
            Log.i(user,pass)
            validar(user,pass)
        }
    }
    private fun initControl() {
        edtUser = findViewById(R.id.edtCorreo)
        edtPass = findViewById(R.id.edtPass)
        btnLogin = findViewById(R.id.btnLogIn)
    }
    fun display(mensje: String){
        Toast.makeText(this,mensje, Toast.LENGTH_SHORT).show()
    }


    fun validar(user: String, pass: String){
        if (user.isEmpty() || pass.isEmpty()){
            display("No pueden existir campos vacios")
        }else{
            login(user,pass)
        }
    }

    private fun login(user: String, pass: String){
        if (user == constantes.user && pass == constantes.pass){
            val intent = Intent(applicationContext,PerfilActivity::class.java)
            startActivity(intent)
        }else{
            display("Error verifique su usuario o su contraseña")
        }
    }

    object constantes{
        const val  user = "prueba@gmail.com"
        const val pass = "12345abcd"
    }


}