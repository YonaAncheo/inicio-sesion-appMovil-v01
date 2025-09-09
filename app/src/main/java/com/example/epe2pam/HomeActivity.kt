package com.example.epe2pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity(){
    lateinit var tvFrase: TextView
    lateinit var btnNuevoConsejo: Button

    val frases = listOf(
        "Escucha y repite diariamente → Dedica 10-15 minutos a escuchar podcasts, canciones o videos en inglés, y repite frases en voz alta para mejorar pronunciación y oído.",
        "Piensa en inglés → Intenta describir lo que haces en tu día a día (ejemplo: I’m cooking dinner, I’m going to work). Esto entrena tu mente a generar frases sin traducir.",
        "Escribe un mini diario → Anota 3-4 oraciones al final del día en inglés sobre lo que hiciste. Esto refuerza vocabulario y gramática básica."
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val usuario = intent.getStringExtra("usuario")
        val tvBienvenida = findViewById<TextView>(R.id.tvBienvenida)
        val btnCerrarSesion = findViewById<Button>(R.id.btnCerrarSesion)

        tvBienvenida.text = "Bienvenido $usuario!"
        tvFrase = findViewById(R.id.tvFrase)
        btnNuevoConsejo = findViewById(R.id.btnNuevoConsejo)

        btnNuevoConsejo.setOnClickListener {
            val fraseAleatoria = frases.random()
            tvFrase.text = fraseAleatoria
        }

        btnCerrarSesion.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}