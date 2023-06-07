package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main9)

        val t1 = intent.getStringExtra("Value1")



        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button15) as Button



        val arrayAdapter: ArrayAdapter<*>
        var Nosaukums = arrayOf(
            "Glabāšana", "Celtniecības un koka skrūves", "Plātņu skrūves", "Rāmja stiprinājumi",
            "Ģipškartona stiprinājumi", "Betona stiprinājumi","Līmes, hermētiķi un ugunsizturīgie hermētiķi","Naglas un naglu pistoles","Kokmateriālu savienotāji",
            "Skrūves un uzgriežņi","Kniedes un lokšņu metāla skrūves","Urbji, uzgaļi un citi", "FireSeal"
        )


        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Nosaukums)
        mListView.adapter = arrayAdapter


        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }

        mListView.setOnItemClickListener(AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
            if(arg2==0) {
                val intent = Intent(this, MainActivity4::class.java)
                startActivity(intent)
            }
            if(arg2==1) {
                val intent = Intent(this, MainActivity14::class.java)
                startActivity(intent)
            }

        })


    }
}