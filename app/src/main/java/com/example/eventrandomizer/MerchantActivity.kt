package com.example.eventrandomizer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MerchantActivity :AppCompatActivity() {
    private lateinit var comerceButton: Button
    private lateinit var continueButton :Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_merchant)

        comerceButton = findViewById<Button>(R.id.comerceButton)
        continueButton = findViewById<Button>(R.id.continueButton3)

        comerceButton.setOnClickListener {
            startActivity(Intent(this,MerchantShopActivity::class.java))
        }
        continueButton.setOnClickListener {
            startActivity(Intent(this,DiceActivity::class.java))
        }

    }
}