package com.example.crudrealtimeclient

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

        val searchBtn = findViewById<Button>(R.id.button)
        val search = findViewById<EditText>(R.id.sea)

        searchBtn.setOnClickListener {
            val searchQuery = search.text.toString()
            if (searchQuery.isNotEmpty()) {
                readData(searchQuery)
            } else {
                Toast.makeText(this, "PLEASE ENTER THE VEHICLE NUMBER", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun readData(vehicleNumber: String) {
        val view1 = findViewById<TextView>(R.id.textView2)
        val view2 = findViewById<TextView>(R.id.textView4)
        val view3 = findViewById<TextView>(R.id.textView6)
        val view4 = findViewById<TextView>(R.id.textView8)
        val linear=findViewById<LinearLayout>(R.id.li)

        databaseReference = FirebaseDatabase.getInstance().getReference("Vehicle Info")
        databaseReference.child(vehicleNumber).get().addOnSuccessListener {
            if (it.exists()) {
                val ownerName = it.child("oname").value
                val vehicleName = it.child("vname").value
                val vehicleRegNum = it.child("vrnum").value
                val vehicleNum = it.child("vnum").value
                linear.alpha=1f

                view1.text = ownerName.toString()
                view2.text = vehicleName.toString()
                view3.text = vehicleRegNum.toString()
                view4.text = vehicleNum.toString()
            } else {
                Toast.makeText(this@MainActivity, "VEHICLE NUMBER DOES NOT EXIST", Toast.LENGTH_SHORT).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this@MainActivity, "FAILED TO RETRIEVE DATA", Toast.LENGTH_SHORT).show()
        }
    }
}
