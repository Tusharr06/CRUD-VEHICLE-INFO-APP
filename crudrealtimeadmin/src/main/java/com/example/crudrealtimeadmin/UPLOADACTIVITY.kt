package com.example.crudrealtimeadmin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class UPLOADACTIVITY : AppCompatActivity() {
    private lateinit var firebaserefernce:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_uploadactivity)
        val save = findViewById<Button>(R.id.save)
        val edt1= findViewById<EditText>(R.id.oname)
        val edt2= findViewById<EditText>(R.id.vname)
        val edt3= findViewById<EditText>(R.id.rto)
        val edt4= findViewById<EditText>(R.id.rtonum)
        save.setOnClickListener{
            val ownername=edt1.text.toString()
            val vehiclename=edt2.text.toString()
            val rto=edt3.text.toString()
            val rtonum= edt4.text.toString()
            firebaserefernce=FirebaseDatabase.getInstance().getReference("Vehicle Info")
            val vdataa=vehicledata(vehiclename,ownername,rto,rtonum)
            firebaserefernce.child(rtonum).setValue(vdataa).addOnSuccessListener {
                edt1.text.clear()
                edt2.text.clear()
                edt3.text.clear()
               edt4.text.clear()
                Toast.makeText(this,"DATA UPLOADED ",Toast.LENGTH_SHORT).show()
                val intent = Intent(this@UPLOADACTIVITY,MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener{
                Toast.makeText(this,"FAIL",Toast.LENGTH_SHORT).show()
            }
        }

    }
}