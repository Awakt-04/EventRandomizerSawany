package com.example.eventrandomizer

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageButton

class DiceActivity : AppCompatActivity() {

    private lateinit var dice : ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        dice = findViewById<ImageButton>(R.id.diceButton)


        dice.setOnClickListener{
            rollDice()
        }
    }

    private fun rollDice() {
        val randomFace = (1..6).random()
        val rotationDegree = 360f * 5 // Rotate 5 times

        val rotateAnimation = RotateAnimation(
            0f, rotationDegree,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )

        rotateAnimation.duration = 1000
        dice.startAnimation(rotateAnimation)

        // Delay to update the dice image after the rotation animation completes
        Handler(Looper.getMainLooper()).postDelayed({
            updateDiceImage(randomFace)
        }, 1000)
    }

    private fun updateDiceImage(face: Int) {
        val drawableId = when (face) {
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5
            else -> R.drawable.dice6
        }

        dice.setImageResource(drawableId)
    }
}