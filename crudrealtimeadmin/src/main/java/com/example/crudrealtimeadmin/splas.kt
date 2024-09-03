package com.example.crudrealtimeadmin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashTimeOut: Long = 1000 // 3 seconds
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splas)
        Handler(Looper.getMainLooper()).postDelayed({
            // Start main activity
            startActivity(Intent(this, MainActivity::class.java))
            // Close splash activity
            finish()
        }, splashTimeOut)
    }
}