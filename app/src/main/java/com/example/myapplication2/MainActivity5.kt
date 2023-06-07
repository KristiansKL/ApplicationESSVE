package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)


        val eText1 = findViewById<EditText>(R.id.editText1)
        val eText2 = findViewById<EditText>(R.id.editText2)
        val eText3 = findViewById<EditText>(R.id.editText3)
        val eText4 = findViewById<EditText>(R.id.editText4)

        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")

        val btn1 = findViewById(R.id.button10) as Button
        val btn2 = findViewById(R.id.button2) as Button



        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)


            if (a1 != null && a2 != null && a3 != null && a4 != null) {
                a1 += eText1.getText().toString()
                a2 += eText2.getText().toString()
                a3 += eText3.getText().toString()
                a4 += eText4.getText().toString()
            }
            intent.putStringArrayListExtra("a1",a1)
            intent.putStringArrayListExtra("a2",a2)
            intent.putStringArrayListExtra("a3",a3)
            intent.putStringArrayListExtra("a4",a4)

            startActivity(intent)
        }
    }
}