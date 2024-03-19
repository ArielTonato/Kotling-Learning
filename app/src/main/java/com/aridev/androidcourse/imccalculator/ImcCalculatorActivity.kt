package com.aridev.androidcourse.imccalculator

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aridev.androidcourse.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var isSelectedComponent: Boolean = true;
    private var currentWeight: Int = 60
    private var currentAge: Int = 16
    private var currentHeight: Int = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeigtht: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var btnSubstractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var tvWeight: TextView
    private lateinit var btnSubstractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var tvAge: TextView
    private lateinit var btnCalculate: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                v.paddingLeft + systemBars.left,
                v.paddingTop + systemBars.top,
                v.paddingRight + systemBars.right,
                v.paddingBottom + systemBars.bottom
            )
            insets
        }
        initComponents()
        initListeners()
        initUi()

    }

    private fun initUi() {
        setGenderColor()
        setWeight(currentWeight)
        setAge(currentAge)
    }

    private fun initComponents() {
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeigtht = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnSubstractAge = findViewById(R.id.btnSubstractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
    }


    private fun initListeners() {

        viewMale.setOnClickListener {
            if (isSelectedComponent) {
                isSelectedComponent = !isSelectedComponent
                Log.i("TAG", "initListeners: $isSelectedComponent")
                changeGender()
                setGenderColor()
            }
        }

        viewFemale.setOnClickListener {
            if (!isSelectedComponent) {
                isSelectedComponent = !isSelectedComponent
                changeGender()
                setGenderColor()
            }
        }

        rsHeight.addOnChangeListener { _, value, _ ->
            var format = DecimalFormat("#.##")
            currentHeight= format.format(value).toInt()
            changeText(currentHeight.toString())
        }

        btnSubstractWeight.setOnClickListener {
            if (currentWeight == 5) return@setOnClickListener
                currentWeight -= 1
                setWeight(currentWeight)

        }

        btnPlusWeight.setOnClickListener {
            currentWeight += 1
            setWeight(currentWeight)
        }

        btnSubstractAge.setOnClickListener {
            if (currentAge == 5) return@setOnClickListener
            currentAge -= 1
            setAge(currentAge)
        }

        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge(currentAge)
        }

        btnCalculate.setOnClickListener {
            calculateIMC();
        }
    }

    private fun calculateIMC() {
        var df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        var result = df.format(imc).toDouble()
        var intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra("imc", result)
        startActivity(intent)
        Log.i("TAG", "calculateIMC: $result")
    }

    private fun setAge(currentAge: Int) {
        tvAge.text = currentAge.toString()
    }

    private fun setWeight(currentWeight: Int) {
        tvWeight.text = currentWeight.toString()
    }

    private fun changeText(height: String) {
        tvHeigtht.text = "$height cm"
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val color = if (isSelectedComponent) R.color.bg_component_selected else R.color.bg_component

        return ContextCompat.getColor(this, color)

    }

}