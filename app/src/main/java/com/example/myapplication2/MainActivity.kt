package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById(R.id.button) as Button

        val userName = findViewById(R.id.editTextTextPersonName) as EditText
        val password = findViewById(R.id.editTextTextPassword) as EditText
        val text = findViewById(R.id.textView10) as TextView

        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            if(userName.text.toString() == "kristians.lilavs" && password.text.toString() == "12345678"){
                startActivity(intent)
            }else {
                text.text = "Nepareizs Lietotājvārds vai parole"

            }

        }

    }
}