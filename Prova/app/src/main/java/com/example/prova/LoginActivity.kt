package com.example.prova

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.danielegiarratano.prova.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza il binding per l'attività di login utilizzando il layoutInflater
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Funzione per verificare la validità dell'email
        fun checkEmail(): Boolean {
            var flag = false
            val email = binding.editTextTextEmailAddress.text.toString()
            if (email.isNotEmpty()) {
                if (email.length >= 8) {
                    flag = true
                } else {
                    Toast.makeText(this, "La email deve contenere almeno 8 caratteri", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "La email è vuota", Toast.LENGTH_SHORT).show()
            }
            return flag
        }

        // Funzione per verificare la validità della password
        @SuppressLint("SuspiciousIndentation")
        fun checkPassword(): Boolean {
            var flag = false
            val password = binding.editTextTextPassword.text.toString()
            if (password.isNotEmpty()) {
                if (password.length >= 8) {
                    flag = true
                } else {
                    Toast.makeText(this, "La password deve contenere almeno 8 caratteri", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "La password è vuota", Toast.LENGTH_SHORT).show()
            }
            return flag
        }

        // Gestisce il clic sul pulsante di login
        binding.button.setOnClickListener {
            val email = checkEmail()
            val password = checkPassword()
            if (email && password) {
                // Se entrambi l'email e la password sono valide, avvia l'attività LoginResultActivity
                val intent = Intent(this, LoginResultActivity::class.java)
                intent.putExtra("email", binding.editTextTextEmailAddress.text.toString())
                intent.putExtra("password", binding.editTextTextPassword.text.toString())
                startActivity(intent)
            }
        }
    }
}
