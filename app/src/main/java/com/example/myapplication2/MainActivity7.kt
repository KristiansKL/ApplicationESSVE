package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val jauns = intent.getIntExtra("jauns", -1)

        val btn1 = findViewById(R.id.button5) as Button
        val btn2 = findViewById(R.id.button11) as Button


        val arrayAdapter: ArrayAdapter<String>
        var Pasutijumi: ArrayList<String>


            Pasutijumi = arrayListOf<String>(
                "Pasūtījums#1 16.02.2022", "Pasūtījums#2 01.04.2023", "Pasūtījums#3 06.06.2023"
            )

        val sdf = SimpleDateFormat("dd.MM.yyyy")
        val currentDate = sdf.format(Date())

        if(jauns == 1){
            Pasutijumi += "Pasūtījums#4 "+ currentDate
        }


        var mListView = findViewById<ListView>(R.id.list1)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Pasutijumi)
        mListView.adapter = arrayAdapter



        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

    }
}