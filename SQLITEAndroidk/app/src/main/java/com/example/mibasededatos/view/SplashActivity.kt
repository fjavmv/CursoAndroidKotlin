package com.example.mibasededatos.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.example.mibasededatos.PrincipalActivity
import com.example.mibasededatos.R
import java.util.Timer
import java.util.TimerTask

class SplashActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val tarea: TimerTask = object : TimerTask() {
            override fun run() {
                val intent = Intent(this@SplashActivity, PrincipalActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        val timer = Timer()
        timer.schedule(tarea, 5000)
    }
}