package com.example.bodymassindex

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivitySecond : AppCompatActivity() {
    private lateinit var resultTV: TextView
    private lateinit var recommendationsTV: TextView
    private lateinit var bodyTypeIV: ImageView
    private lateinit var result: String
    private lateinit var recommendations: Recommendations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        result = intent.getStringExtra("imb").toString()
        recommendations = Recommendations(result.toDouble())
        resultTV.text = result
        recommendationsTV.text = recommendation()
    }

    private fun recommendation(): String {
        val res = when (recommendations.imb) {
            in 0.0..<18.5 -> {
                bodyTypeIV.setImageResource(R.drawable.thin)
                "\tДефицит массы тела\n${recommendations.indexOne}"
            }

            in 18.5..24.9 -> {
                bodyTypeIV.setImageResource(R.drawable.normal)
                "\tНормальная масса тела\n${recommendations.indexSecond}"
            }

            in 25.0..29.9 -> {
                bodyTypeIV.setImageResource(R.drawable.thick)
                "\tИзбыточная масса тела\n${recommendations.indexThird}"
            }

            in 30.0..34.9 -> {
                bodyTypeIV.setImageResource(R.drawable.thick)
                "\tОжирение I степени\n${recommendations.indexFourth}"
            }

            in 35.0..39.9 -> {
                bodyTypeIV.setImageResource(R.drawable.thick)
                "\tОжирение II степени\n${recommendations.indexFifth}"
            }

            in 40.0..500.0 -> {
                bodyTypeIV.setImageResource(R.drawable.thick)
                "\tОжирение III степени\n${recommendations.indexSixth}"
            }

            else -> "Ошибка! Неверные данные!"
        }
        return res
    }

    private fun init() {
        setContentView(R.layout.activity_main_second)
        resultTV = findViewById(R.id.resultTV)
        recommendationsTV = findViewById(R.id.recommendationsTV)
        bodyTypeIV = findViewById(R.id.bodyTypeIV)
    }
}