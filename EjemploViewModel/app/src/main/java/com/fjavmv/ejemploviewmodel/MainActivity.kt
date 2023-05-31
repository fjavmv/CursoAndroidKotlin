package com.fjavmv.ejemploviewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.edit
import androidx.lifecycle.ViewModelProvider
import com.fjavmv.ejemploviewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var  binding: ActivityMainBinding
    private lateinit var sp: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sp = getPreferences(Context.MODE_PRIVATE)
        val almacenarContador = sp.getInt("contador",0)
        viewModel = ViewModelProvider(this,MainViewModelFactory(almacenarContador))[MainViewModel::class.java]

       //viewModel = ViewModelProvider(this)[MainViewModel::class.java]


        binding.incrementarBtn.setOnClickListener {
            viewModel.contador++
            actualizarContador()
        }

       binding.limpiarBtn.setOnClickListener {
            viewModel.contador = 0
            actualizarContador()
        }

        actualizarContador()
    }

    private fun actualizarContador() {
        binding.infoTxt.text = viewModel.contador.toString()
    }

   override fun onPause() {
        super.onPause()
        sp.edit{
            putInt("contador",viewModel.contador)
        }
    }

    /*
    ¿Qué pasa si tenemos que pasar algunos parametross al constructor?
    Dado que todas las instancias de ViewModel se adquieren a través
    de ViewModelProvider, no hay forma de que podamos pasar param directamente
    a ViewModel.
    Podemos usar ViewModelProvider.Factory para resolverlo.

    El contador actual puede conservar los datos durante la rotación de la pantalla,
    pero no al reiniciar la aplicación.

     */


}