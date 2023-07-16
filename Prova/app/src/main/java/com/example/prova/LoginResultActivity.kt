package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.prova.databinding.ActivityLoginResultBinding

class LoginResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza il binding per l'attività di risultato del login utilizzando il layoutInflater
        binding = ActivityLoginResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ottiene l'email e la password passate dall'attività precedente tramite l'intent
        val email = intent.getStringExtra("email")
        val password = intent.getStringExtra("password")

        // Imposta l'email nella TextView dell'interfaccia utente
        binding.textView.text = email

        // Imposta la password nella TextView dell'interfaccia utente
        binding.textView2.text = password
    }
}
