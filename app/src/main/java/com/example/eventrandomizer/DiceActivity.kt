package com.example.eventrandomizer

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageButton
import android.widget.ImageView

class DiceActivity : AppCompatActivity() {

    private lateinit var dice : ImageButton
    private lateinit var scenario : ImageView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        scenario = findViewById(R.id.scenarioImage)
        dice = findViewById(R.id.diceButton)

        when ((1..4).random()){
            1 -> scenario.setImageResource(R.drawable.cave)
            2 -> scenario.setImageResource(R.drawable.city)
            3 -> scenario.setImageResource(R.drawable.field)
            4 -> scenario.setImageResource(R.drawable.mountains)
        }


        dice.setOnClickListener{

            when (rollDice()){
                1,
                2 -> {
                    Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this,EnemyActivity::class.java))},
                        1000)

                }
                3 ->Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this,MerchantActivity::class.java))},
                        1000)
                4 ->  Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this,CityActivity::class.java))},
                        1000)
                5,
                6 -> Handler(Looper.getMainLooper()).postDelayed({
                        startActivity(Intent(this,ItemActivity::class.java))},
                        1000)
            }
        }
    }

    private fun rollDice() :Int {
        // variable para obtener una cara aleatoria del dado
        val randomFace = (1..6).random()
        val rotationDegree = 360f * (1..6).random() // Rota de 1 a seis veces de forma aleatoria

        // creamos una variable para poder realizar la animación entre 0 y las vueltas obtenidas con la variable anterior
        val rotateAnimation = RotateAnimation(
            0f, rotationDegree,
            // estos valores hacen referencia a la propia animación y los valores de X e Y son 0.5 para que rote sobre sí mismo
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        // hacemos que rote durante un segundo e iniciamos la animación
        rotateAnimation.duration = 1000
        dice.startAnimation(rotateAnimation)

        // Se utiliza un handler para poder actualizar la imagen del dado con un delay de medio segundo
        Handler(Looper.getMainLooper()).postDelayed({
            updateDiceImage(randomFace)
        }, 500)

        return randomFace
    }

    // función para actualizar la imagen del dado
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