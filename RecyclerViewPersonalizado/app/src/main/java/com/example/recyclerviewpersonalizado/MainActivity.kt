package com.example.recyclerviewpersonalizado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerAgenda : RecyclerView
    private lateinit var listaAgenda: ArrayList<Agenda>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    init {
        recyclerAgenda = findViewById(R.id.recyclerAgenda)
    }
}