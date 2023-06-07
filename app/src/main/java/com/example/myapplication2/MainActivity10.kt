package com.example.myapplication2

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get

class MainActivity10 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val array1 = intent.getStringArrayListExtra("array1")



        val a1 = intent.getStringArrayListExtra("a1")


        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button9) as Button


        var array: ArrayList<String>

        if (array1 != null) {
            array = array1
        }else {array = arrayListOf()
        }

        val arrayAdapter: ArrayAdapter<String>
        var Nosaukums: ArrayList<String>


            Nosaukums = arrayListOf<String>(
                "ESSBOX slēdzis-2gab", "ESSbox kastes pleca siksna", "CASE STAND FOR ESSBOX CASE",
                "ESSBOX SYSTAINER CASE", "ESSBOX paklājs", "Konstr.sk.ET-T 6,5X65 CS-100gb", "ROOFING SCREW 5,5X20 BLACK",
                "Jumta sk. 4,8X25 VS Zn-250gab.", "Skrūve 6,5X38A 6KB Zn-200gab.", "Skrūve 6,5X38 Zn-200gab."
            )



        var mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Nosaukums)
        mListView.adapter = arrayAdapter


        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity8::class.java)
            intent.putStringArrayListExtra("array1", array)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity8::class.java)
            intent.putStringArrayListExtra("array1", array)
            startActivity(intent)
        }

        mListView.setOnItemClickListener(AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->

            mListView[arg2].setBackgroundColor(Color.parseColor("#87b851"))

            array.add(Nosaukums[arg2])



        })

    }
}