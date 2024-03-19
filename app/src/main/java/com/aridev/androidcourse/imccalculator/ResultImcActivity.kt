package com.aridev.androidcourse.imccalculator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aridev.androidcourse.R

class ResultImcActivity : AppCompatActivity() {

    lateinit var tvResult: TextView
    lateinit var tvTextIMC: TextView
    lateinit var tvDescriptionIMC: TextView
    lateinit var btnBack: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imc)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initComponents()
        initUI()
        initListeners()
    }

    fun initListeners() {
        btnBack.setOnClickListener {
            finish()
        }
    }

    fun initUI() {
        val imc = intent.getDoubleExtra("imc", 0.0)
        setResultIMC(imc)
        setTextIMC(imc)
    }

    fun initComponents() {
        tvResult = findViewById<TextView>(R.id.tvResult)
        tvTextIMC = findViewById<TextView>(R.id.tvTextIMC)
        tvDescriptionIMC = findViewById<TextView>(R.id.tvDescriptionIMC)
        btnBack = findViewById<AppCompatButton>(R.id.btnBack)
    }

    fun setResultIMC(imc: Double) {
        tvResult.text = imc.toString()
    }

    fun setTextIMC(imc: Double) {
        when (imc) {
            in 0.0..18.5 -> {
                tvTextIMC.text = "Bajo peso"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescriptionIMC.text =
                    "Tienes un peso bajo, es importante que te alimentes bien y hagas ejercicio."
            }

            in 18.5..24.9 -> {
                tvTextIMC.text = "Peso normal"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.normal))
                tvDescriptionIMC.text = "Tienes un peso normal, sigue así."
            }

            in 25.0..29.9 -> {
                tvTextIMC.text = "Sobrepeso"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescriptionIMC.text =
                    "Tienes sobrepeso, es importante que hagas ejercicio y cuides tu alimentación."
            }

            in 30.0..34.9 -> {
                tvTextIMC.text = "Obesidad grado 1"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.obesidad1))
                tvDescriptionIMC.text =
                    "Tienes obesidad grado 1, es importante que hagas ejercicio y cuides tu alimentación."
            }

            in 35.0..39.9 -> {
                tvTextIMC.text = "Obesidad grado 2"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.obesidad2))
                tvDescriptionIMC.text =
                    "Tienes obesidad grado 2, es importante que hagas ejercicio y cuides tu alimentación."
            }

            else -> {
                tvTextIMC.text = "Obesidad grado 3"
                tvTextIMC.setTextColor(ContextCompat.getColor(this, R.color.obesidad3))
                tvDescriptionIMC.text =
                    "Tienes obesidad grado 3, es importante que hagas ejercicio y cuides tu alimentación."
            }
        }
    }


}