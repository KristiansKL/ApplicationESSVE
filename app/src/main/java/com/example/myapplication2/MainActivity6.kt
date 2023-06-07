package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var text1 = findViewById<View>(R.id.editText1) as TextView
        var text2 = findViewById<View>(R.id.editText2) as TextView
        var text3 = findViewById<View>(R.id.editText3) as TextView
        var text4 = findViewById<View>(R.id.editText4) as TextView

        val num = intent.getIntExtra("i", -1)


        val a1 = intent.getStringArrayListExtra("a1")
        val a2 = intent.getStringArrayListExtra("a2")
        val a3 = intent.getStringArrayListExtra("a3")
        val a4 = intent.getStringArrayListExtra("a4")

        text1.text = a1!![num]
        text2.text = a2!![num]
        text3.text = a3!![num]
        text4.text = a4!![num]

        val btn1 = findViewById(R.id.button10) as Button
        val btn2 = findViewById(R.id.button2) as Button
        val btn3 = findViewById(R.id.button3) as Button

        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)

            a1[num] = text1.getText().toString()
            a2[num] = text2.getText().toString()
            a3[num] = text3.getText().toString()
            a4[num] = text4.getText().toString()

            intent.putStringArrayListExtra("a1",a1)
            intent.putStringArrayListExtra("a2",a2)
            intent.putStringArrayListExtra("a3",a3)
            intent.putStringArrayListExtra("a4",a4)


            intent.putExtra("num",num)
            startActivity(intent)

        }

        btn3.setOnClickListener{
            val intent = Intent(this, MainActivity13::class.java)
            intent.putExtra("del",num)

            a1.toMutableList()
            a1.removeAt(num)
            a1.toArray()

            intent.putStringArrayListExtra("a1",a1)
            intent.putStringArrayListExtra("a2",a2)
            intent.putStringArrayListExtra("a3",a3)
            intent.putStringArrayListExtra("a4",a4)

            startActivity(intent)


        }
    }
}