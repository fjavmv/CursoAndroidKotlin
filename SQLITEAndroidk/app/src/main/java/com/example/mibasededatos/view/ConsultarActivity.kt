package com.example.mibasededatos.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mibasededatos.R
import com.example.mibasededatos.adapter.AdapterConsultaClienteAdeudo
import com.example.mibasededatos.daos.DaoConsultaClienteAdeudo
import com.example.mibasededatos.daos.IDaoConsultaClienteAdeudo
import com.example.mibasededatos.entidades.ConsultaClienteAdeudoDto

class ConsultarActivity : AppCompatActivity(), IConsultarActivity {
    private lateinit var recyclerView: RecyclerView
    private lateinit var listaClienteAdeudo: ArrayList<ConsultaClienteAdeudoDto>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_consultar)
        recyclerView = findViewById(R.id.rViewConsulta)
        construirRecyclerElementos()
    }

    override fun consultarAdeudosClientes(): ArrayList<ConsultaClienteAdeudoDto> {
        val iDaoConsultaClienteAdeudo: IDaoConsultaClienteAdeudo = DaoConsultaClienteAdeudo(this)
        return iDaoConsultaClienteAdeudo.consultarAdeudosClientes()
    }

    override fun construirRecyclerElementos() {
        listaClienteAdeudo = ArrayList()
        listaClienteAdeudo = consultarAdeudosClientes()
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val adapterDatos = AdapterConsultaClienteAdeudo(listaClienteAdeudo)
        recyclerView.setOnClickListener {
            //     id = listaCLiente.get(recyclerViewCLientes.getChildAdapterPosition(view)).getIdCliente() ;
            //   editTextNombreCLiente.setText(listaCLiente.get((int)id-1).toString());
            // mostrarToast("id:"+ id);
        }
        recyclerView.adapter = adapterDatos
    }
}