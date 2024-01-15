package com.example.eventrandomizer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class CityActivity :AppCompatActivity() {
    private lateinit var enterButton : Button
    private lateinit var continueButton : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_city)
        enterButton = findViewById(R.id.enterButton)
        continueButton = findViewById(R.id.continueButton2)

        enterButton.setOnClickListener {
            startActivity(Intent(this,CityEnterActivity::class.java))
        }
        continueButton.setOnClickListener {
            startActivity(Intent(this,DiceActivity::class.java))
        }

    }
}