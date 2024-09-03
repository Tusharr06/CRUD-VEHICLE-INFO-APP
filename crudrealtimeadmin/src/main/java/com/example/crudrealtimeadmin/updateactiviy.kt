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
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class updateactiviy : AppCompatActivity() {
    private lateinit var datbasereference:DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_updateactiviy)
        var u1=findViewById<EditText>(R.id.utextView)
        var u2=findViewById<EditText>(R.id.utextView2)
        var u3=findViewById<EditText>(R.id.utextView3)
        var u4=findViewById<EditText>(R.id.utextView4)

var update =findViewById<Button>(R.id.button2)
        update.setOnClickListener{
            val ownername=u2.text.toString()
            val vehiclename=u3.text.toString()
            val rto=u4  .text.toString()
            val rtonum= u1.text.toString()
            updatethedata(rtonum,ownername,vehiclename,rto)

        }



    }
    private fun updatethedata(vehiclenumber:String,ownername:String,vehiclename:String,rto:String){
        datbasereference=FirebaseDatabase.getInstance().getReference("Vehicle Info")
        val vehicledata= mapOf("oname" to ownername,"vname" to vehiclename,"vrnum" to rto)
        datbasereference.child(vehiclenumber).updateChildren(vehicledata).addOnSuccessListener {
            Toast.makeText(this,"DATA UPDATED", Toast.LENGTH_SHORT).show()
            val intent = Intent(this@updateactiviy,MainActivity::class.java)
            startActivity(intent)
            finish()

        }.addOnFailureListener{
            Toast.makeText(this,"FAIL", Toast.LENGTH_SHORT).show()

        }
    }
}