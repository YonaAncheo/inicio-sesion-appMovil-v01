package com.example.epe2pam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    private val usuarioCorrecto = "admin"
    private val passwordCorrecto = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etUsuario = findViewById<EditText>(R.id.etUsuario)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val usuario = etUsuario.text.toString()
            val password = etPassword.text.toString()

            if(usuario.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Completa todos los campos",
                    Toast.LENGTH_SHORT).show()
            } else if(usuario==usuarioCorrecto && password==passwordCorrecto){
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("usuario",usuario)
                startActivity(intent)
            } else{
                Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            }
        }
    }
}