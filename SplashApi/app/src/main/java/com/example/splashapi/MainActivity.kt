package com.example.splashapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.window.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val screenSplash = installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Inicializamos splash
        Thread.sleep(1000)
        screenSplash.setKeepOnScreenCondition{true}
        val intent = Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }
}