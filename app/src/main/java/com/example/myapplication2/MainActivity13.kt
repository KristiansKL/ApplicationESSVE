package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity13 : AppCompatActivity() {

    lateinit var listview: ListView


    lateinit var listAdapter: ArrayAdapter<String>


    lateinit var Nosaukums: ArrayList<String>;


    lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
        setContentView(R.layout.activity_main13)

        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")

        val btn1 = findViewById(R.id.button8) as Button
        val btn2 = findViewById(R.id.button9) as Button


        listview = findViewById(R.id.list)
        searchView = findViewById(R.id.srchv)

        Nosaukums = ArrayList()


        var Nosaukums: ArrayList<String>
        var ArtNr: ArrayList<String>
        var Svars: ArrayList<String>
        var PrecesAdrese: ArrayList<String>

        if(a1 == null){
            Nosaukums = arrayListOf<String>(
                "ESSBOX slēdzis-2gab", "ESSbox kastes pleca siksna", "CASE STAND FOR ESSBOX CASE",
                "ESSBOX SYSTAINER CASE", "ESSBOX paklājs", "Konstr.sk.ET-T 6,5X65 CS-100gb", "ROOFING SCREW 5,5X20 BLACK", "Jumta sk. 4,8X25 VS Zn-250gab.", "Skrūve 6,5X38A 6KB Zn-200gab.", "Skrūve 6,5X38 Zn-200gab."
            )
        }else{Nosaukums = a1}


        if(a2 == null){
            ArtNr = arrayListOf<String>(
                "460985", "460960", "9912902",
                "460939", "9916754", "118100", "63248", "64201", "63036", "63336"
            )
        }else{ ArtNr = a2}

        if(a3 == null){
            Svars = arrayListOf<String>(
                "30", "25", "30",
                "19", "10",  "30", "25", "30","19", "10"
            )} else{Svars = a3}

        if(a4 == null){
            PrecesAdrese = arrayListOf<String>(
                "K2-03-A-12", "K2-03-A-12", "K2-03-A-12",
                "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12", "K2-03-A-12"
            )} else{PrecesAdrese = a4}


        listAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_1,
            Nosaukums
        )

        listview.adapter = listAdapter

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (Nosaukums.contains(query)) {

                    listAdapter.filter.filter(query)
                } else {
                    Toast.makeText(this@MainActivity13, "Nav tāda produkta..", Toast.LENGTH_LONG)
                        .show()
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                listAdapter.filter.filter(newText)
                return false
            }
        })

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

        listview.setOnItemClickListener(AdapterView.OnItemClickListener { arg0, arg1, arg2, arg3 ->
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