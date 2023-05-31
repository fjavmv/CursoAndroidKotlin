package com.fjavmv.ejemploviewmodel

import androidx.lifecycle.ViewModel

class MainViewModel(almacenarContador: Int): ViewModel() {
    var contador = almacenarContador

}

















/*
El parámetro almacenarContador tendrá el valor del contador guardado
e inicializará el contador con este valor durante la inicialización.
¿Cómo pasar datos al constructor de MainViewModel a través de ViewModelProvider.Factory?
Necesitamos crear la clase MainViewModelFactory que implementa la interfaz ViewModelProvider.Factory
 */