package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val btn1 = findViewById(R.id.button2) as Button
        val btn2 = findViewById(R.id.button16) as Button

        val cb1 = findViewById(R.id.checkBox) as CheckBox
        val cb2 = findViewById(R.id.checkBox2) as CheckBox

        val vards = findViewById(R.id.editTextTextPersonName2) as EditText
        val uzvards = findViewById(R.id.editTextTextPersonName3) as EditText
        var lietotajvards = findViewById(R.id.editTextTextPersonName4) as EditText


        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity12::class.java)
            intent.putExtra("vards", vards.text.toString())
            intent.putExtra("uzvards", uzvards.text.toString())
            if(cb1.isChecked){
                intent.putExtra("D", "Darbinieks")
            }
            if(cb2.isChecked){
                intent.putExtra("D", "Administrators")
            }

            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity12::class.java)
            startActivity(intent)
        }

        lietotajvards.setOnClickListener{
            var lvards = vards.text.toString() + "." + uzvards.text.toString()
            lietotajvards.setText(lvards)
        }

    }
}
