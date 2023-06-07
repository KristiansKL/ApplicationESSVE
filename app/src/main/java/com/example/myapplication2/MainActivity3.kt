package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val btn1 = findViewById(R.id.button4) as Button
        val btn2 = findViewById(R.id.button5) as Button
        val btn3 = findViewById(R.id.button6) as Button
        val btn4 = findViewById(R.id.textView4) as TextView

        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        btn3.setOnClickListener{
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }
        btn4.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
