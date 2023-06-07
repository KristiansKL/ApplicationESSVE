package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity14 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main14)



        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")



        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button9) as Button

        val arrayAdapter: ArrayAdapter<String>
        var Nosaukums: ArrayList<String>
        var ArtNr: ArrayList<String>
        var Svars: ArrayList<String>
        var PrecesAdrese: ArrayList<String>

        if(a1 == null){
            Nosaukums = arrayListOf<String>(
                "Konstr.sk.ET-T 6,5X65 CS-100gb", "ROOFING SCREW 5,5X20 BLACK", "Jumta sk. 4,8X25 VS Zn-250gab.", "Skrūve 6,5X38A 6KB Zn-200gab.", "Skrūve 6,5X38 Zn-200gab."
            )
        }else{Nosaukums = a1}


        if(a2 == null){
            ArtNr = arrayListOf<String>(
                "118100", "63248", "64201", "63036", "63336"
            )
        }else{ ArtNr = a2}

        if(a3 == null){
            Svars = arrayListOf<String>(
                "3.0", "2.5", "30", "1.9", "10"
            )} else{Svars = a3}

        if(a4 == null){
            PrecesAdrese = arrayListOf<String>(
                "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12"
            )} else{PrecesAdrese = a4}

        var mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Nosaukums)
        mListView.adapter = arrayAdapter



        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity5::class.java)

            intent.putStringArrayListExtra("a1", Nosaukums)
            intent.putStringArrayListExtra("a2", ArtNr)
            intent.putStringArrayListExtra("a3", Svars)
            intent.putStringArrayListExtra("a4", PrecesAdrese)

            startActivity(intent)
        }


        mListView.setOnItemClickListener(AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val intent = Intent(this, MainActivity6::class.java)
            var i = arg2

            intent.putStringArrayListExtra("a1", Nosaukums)
            intent.putStringArrayListExtra("a2", ArtNr)
            intent.putStringArrayListExtra("a3", Svars)
            intent.putStringArrayListExtra("a4", PrecesAdrese)

            intent.putExtra("i", i)
            startActivity(intent)

        })


    }


    }


