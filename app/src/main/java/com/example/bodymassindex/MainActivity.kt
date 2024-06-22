package com.example.bodymassindex

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var heightET: EditText
    private lateinit var weightET: EditText
    private lateinit var calculateBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()

        calculateBTN.setOnClickListener {
            val weight = weightET.text.toString().toDouble()
            val height = heightET.text.toString().toDouble()
            val imb = indexMasBody(weight, height).toInt()
            val intent = Intent(this, MainActivitySecond::class.java)
            intent.putExtra("imb", imb.toString())
            startActivity(intent)
        }
    }

    private fun init() {
        heightET = findViewById(R.id.heightET)
        weightET = findViewById(R.id.weightET)
        calculateBTN = findViewById(R.id.calculateBTN)
    }

    private fun indexMasBody(weight: Double, height: Double) = weight / (height * height)
}