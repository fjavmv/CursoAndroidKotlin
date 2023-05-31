package com.fjavmv.viewbindingdbroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fjavmv.viewbindingdbroom.adapterRecycler.AdapterRecycler
import com.fjavmv.viewbindingdbroom.databinding.ActivityMainBinding
import com.fjavmv.viewbindingdbroom.entidad.User
import com.fjavmv.viewbindingdbroom.repository.UserRepository
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding:  ActivityMainBinding
    private lateinit var listUser: List<User>
    private lateinit var adapterRecycler: AdapterRecycler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        UserRepository.inicializar(this)
        val db = UserRepository.get()

        binding.button.setOnClickListener {
            lifecycleScope.launch {
                insertar(db)
                Toast.makeText(applicationContext,"Elemento insertado",Toast.LENGTH_SHORT).show()
            }
        }

        binding.button2.setOnClickListener {
            lifecycleScope.launch {
                listUser = listUser(db)
                construirRecyclerUser()
                adapterRecycler.notifyItemInserted(listUser.lastIndex)

            }
        }


    }


    private suspend fun listUser(db: UserRepository): List<User>{
        return db.getAll()
    }

    private suspend fun insertar(db: UserRepository){
        val user = User(binding.edtnombre.text.toString(),binding.edtApellido.text.toString(),binding.edtEdad.text.toString())
        db.insertAll(user)

    }

    private fun construirRecyclerUser(){
        binding.rcvUsers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        adapterRecycler = AdapterRecycler(listUser)
        binding.rcvUsers.adapter = adapterRecycler
    }

}