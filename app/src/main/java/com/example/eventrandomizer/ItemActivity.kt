package com.example.eventrandomizer

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ItemActivity :AppCompatActivity() {
    private lateinit var pickupButton :Button
    private lateinit var continueButton : Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        pickupButton = findViewById(R.id.pickupButton)
        continueButton = findViewById(R.id.continueButton1)

        pickupButton.setOnClickListener {
            val intent = Intent(this,DiceActivity::class.java)
            startActivity(intent)
        }
        continueButton.setOnClickListener {
            startActivity(Intent(this,DiceActivity::class.java))
        }

    }
}