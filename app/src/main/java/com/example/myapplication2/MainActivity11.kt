package com.example.myapplication2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main11)

        val num = intent.getIntExtra("i",-1)
        val array1 = intent.getStringArrayListExtra("array1")

        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")

        val btn1 = findViewById<Button>(R.id.button8)
        val btn2 = findViewById<Button>(R.id.button9)

        val text1 = findViewById<TextView>(R.id.textView7)
        val text2 = findViewById<TextView>(R.id.textView8)
        val text3 = findViewById<TextView>(R.id.textView9)

        val edittext = findViewById<TextView>(R.id.editTextText2)


        text1.text = a1!![num]
        text2.text = a2!![num]
        text3.text = a4!![num]


        var array: ArrayList<String>

        if (array1 != null) {
            array = array1
        }else {array = arrayListOf()
        }

        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity10::class.java)
            array += text1.text.toString() + "\n" + edittext.text.toString()
            intent.putStringArrayListExtra("array1", array)

            startActivity(intent)
        }

    }
}