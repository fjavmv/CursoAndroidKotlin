package com.fjavmv.roomdb.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.fjavmv.roomdb.R
import com.fjavmv.roomdb.adapterRecycler.AdapterRecycler
import com.fjavmv.roomdb.db.AppDatabase
import com.fjavmv.roomdb.entidad.User
import com.fjavmv.roomdb.repository.UserRepository
import kotlinx.coroutines.launch
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtApellido: EditText
    private lateinit var edtEdad: EditText
    private lateinit var btnGuardar: Button
    private lateinit var btnRecorrer: Button
    private lateinit var rcvUser: RecyclerView
    private lateinit var listUser: List<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initControl()
        UserRepository.inicializar(this)
        val db = UserRepository.get()

        btnGuardar.setOnClickListener {
            lifecycleScope.launch {
                insertar(db)
                Toast.makeText(applicationContext,"Elemento insertado",Toast.LENGTH_SHORT).show()
            }
        }

        btnRecorrer.setOnClickListener {
            lifecycleScope.launch {
                construirRecyclerUser(listUser(db))
            }
        }
    }

    private fun initControl(){
        edtNombre = findViewById(R.id.edtnombre)
        edtApellido = findViewById(R.id.edtApellido)
        edtEdad = findViewById(R.id.edtEdad)
        btnGuardar = findViewById(R.id.button)
        btnRecorrer = findViewById(R.id.button2)
        rcvUser = findViewById(R.id.rcvUsers)
    }

    private suspend fun listUser(db:UserRepository): List<User>{
        return db.getAll()
    }

    suspend fun insertar(db: UserRepository){
        val user = User(edtNombre.text.toString(),edtApellido.text.toString(),edtEdad.text.toString())
        db.insertAll(user)

    }

    fun construirRecyclerUser(list: List<User>){
        listUser = list
        rcvUser.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val adapter = AdapterRecycler(listUser)
        rcvUser.adapter = adapter
    }

}