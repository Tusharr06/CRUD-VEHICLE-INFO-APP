package com.example.crudrealtimeadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        var update =findViewById<Button>(R.id.utton)
        var upload = findViewById<Button>(R.id.upload)
        upload.setOnClickListener{
            val intent = Intent(this@MainActivity,UPLOADACTIVITY::class.java)
            startActivity(intent)

        }
        update.setOnClickListener{
            val intent = Intent(this@MainActivity,updateactiviy::class.java)
            startActivity(intent)

        }

    }
}