package com.example.myapplication2

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator
import org.json.JSONException
import org.json.JSONObject





class MainActivity8 : AppCompatActivity() {


    lateinit var Pasutijumi: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)



        val array1 = intent.getStringArrayListExtra("array1")


        val btn1 = findViewById(R.id.button13) as Button
        val btn2 = findViewById(R.id.button14) as Button
        val btn3 = findViewById(R.id.button12) as Button
        val btn4 = findViewById(R.id.button) as Button

        val arrayAdapter: ArrayAdapter<String>


        if(array1 == null){
            Pasutijumi = arrayListOf<String>(
            )
        }else{Pasutijumi = array1}

        var mListView = findViewById<ListView>(R.id.list)
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, Pasutijumi)
        mListView.adapter = arrayAdapter

        btn1.setOnClickListener{
            val intent = Intent(this, MainActivity7::class.java)
            startActivity(intent)
        }
        btn2.setOnClickListener{
            val intent = Intent(this, MainActivity7::class.java)

            intent.putExtra("jauns", 1)
            startActivity(intent)
        }
        btn3.setOnClickListener{
            val intent = Intent(this, MainActivity10::class.java)
            intent.putStringArrayListExtra("array1", array1)
            startActivity(intent)
        }

        btn4.setOnClickListener{
            val intentIntegrator = IntentIntegrator(this@MainActivity8)
            intentIntegrator.setBeepEnabled(false)
            intentIntegrator.setOrientationLocked(false)
            intentIntegrator.setCameraId(0)
            intentIntegrator.setPrompt("SCAN")
            intentIntegrator.setBarcodeImageEnabled(false)
            intentIntegrator.initiateScan()
        }

    }

override fun onActivityResult(
    requestCode: Int,
    resultCode: Int,
    data: Intent?
) {
    val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
    if (result != null) {
        if (result.contents == null) {
            Toast.makeText(this, "cancelled", Toast.LENGTH_SHORT).show()
        } else {
            Log.d("MainActivity8", "Scanned")
            Toast.makeText(this, "Scanned -> " + result.contents, Toast.LENGTH_SHORT)
                .show()
            // textView.text = String.format("Scanned Result: %s", result)
            Pasutijumi += result.contents.toString()
            val intent = Intent(this, MainActivity8::class.java)
            intent.putStringArrayListExtra("array1", Pasutijumi)
            startActivity(intent)
        }
    } else {
        super.onActivityResult(requestCode, resultCode, data)
    }
}


}