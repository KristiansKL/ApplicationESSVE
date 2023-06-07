package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity12 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main12)


        val v = intent.getStringExtra("vards")
        val uz = intent.getStringExtra("uzvards")
        val d = intent.getStringExtra("D")




        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button9) as Button

        val arrayAdapter: ArrayAdapter<String>
        var Nosaukums: ArrayList<String>



            Nosaukums = arrayListOf<String>(
                "Kristiāns Lilavs (Adminstrators)\nPēdējo reizi lietotne tika izmantota - tiešsaistē", "Valters Gulbis (Darbinieks)\n" +
                        "Pēdējo reizi lietotne tika izmantota - 07/06/2023 14:27"
            )
        if(v != null) {Nosaukums.add(v.toString() + " " + uz.toString() + " ("+ d.toString() + ")")}


        var mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Nosaukums)
        mListView.adapter = arrayAdapter



        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)

            intent.putStringArrayListExtra("a1", Nosaukums)


            startActivity(intent)
        }




    }

}