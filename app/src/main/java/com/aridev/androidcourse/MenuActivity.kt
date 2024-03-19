package com.aridev.androidcourse

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.aridev.androidcourse.firstapp.FirstAppActivity
import com.aridev.androidcourse.imccalculator.ImcCalculatorActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludar = findViewById<Button>(R.id.btnSaludApp)
        val btnImc = findViewById<Button>(R.id.btnImcApp)
        btnSaludar.setOnClickListener {
            navigateToSaludApp()
        }
        btnImc.setOnClickListener {
            navigateToImcApp()
        }
    }

    private fun navigateToSaludApp(){
        val itent = Intent(this, FirstAppActivity::class.java)
        startActivity(itent)
    }

    private fun navigateToImcApp(){
        val itent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(itent)
    }
}