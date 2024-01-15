package com.example.eventrandomizer

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class EnemyActivity :AppCompatActivity() {
    private lateinit var fightButton : Button
    private lateinit var fleeButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enemy)

        fightButton = findViewById(R.id.fightButton)
        fleeButton = findViewById(R.id.fleeButton)

        fightButton.setOnClickListener {
            startActivity(Intent(this,EnemyFightActivity::class.java))
        }
    }
}