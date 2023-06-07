package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity


class MainActivity4 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")



        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button9) as Button

        val arrayAdapter: ArrayAdapter<String>
        var Nosaukums: ArrayList<String>
        var ArtNr: ArrayList<String>
        var Daudzums: ArrayList<String>
        var EAN: ArrayList<String>

        if(a1 == null){
            Nosaukums = arrayListOf<String>(
                "ESSBOX slēdzis-2gab", "ESSbox kastes pleca siksna", "CASE STAND FOR ESSBOX CASE",
                "ESSBOX SYSTAINER CASE", "ESSBOX paklājs"
            )
        }else{Nosaukums = a1}


        if(a2 == null){
         ArtNr = arrayListOf<String>(
            "460985", "460960", "9912902",
            "460939", "9916754"
        )
        }else{ ArtNr = a2}

        if(a3 == null){
         Daudzums = arrayListOf<String>(
            "30gab", "25gap", "30gap",
            "19gap", "10gap"
        )} else{Daudzums = a3}

        if(a4 == null){
         EAN = arrayListOf<String>(
            "07317761227489", "07317761047964", "07317761043522",
            "07317761229032", "07317761043423"
        )} else{EAN = a4}

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
            intent.putStringArrayListExtra("a3", Daudzums)
            intent.putStringArrayListExtra("a4", EAN)

            startActivity(intent)
        }


        mListView.setOnItemClickListener(OnItemClickListener { arg0, arg1, arg2, arg3 ->
            val intent = Intent(this, MainActivity6::class.java)
            var i = arg2

            intent.putStringArrayListExtra("a1", Nosaukums)
            intent.putStringArrayListExtra("a2", ArtNr)
            intent.putStringArrayListExtra("a3", Daudzums)
            intent.putStringArrayListExtra("a4", EAN)

            intent.putExtra("i",i)
            startActivity(intent)

        })


    }



}