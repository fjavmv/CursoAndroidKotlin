package com.fjavmv.pedidos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.fjavmv.pedidos.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun menuOnclick(view: View){
        view.setOnClickListener {
            val intent = Intent(this,MenuImp::class.java)
            startActivity(intent)
        }
    }


}