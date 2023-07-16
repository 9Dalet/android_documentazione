package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import com.example.prova.databinding.ActivityDetailBinding
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza il binding per l'attività di dettaglio utilizzando il layoutInflater
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ottiene i dati passati dall'attività precedente tramite l'intent
        val itemName = intent.getStringExtra("name")
        val itemUrl = intent.getStringExtra("url")
        val itemDetail = intent.getStringExtra("details")

        // Verifica se tutti i dati sono presenti (non nulli) utilizzando let()
        itemName?.let {
            itemUrl?.let {
                itemDetail?.let {
                    // Imposta il nome dell'oggetto nei dettagli dell'interfaccia utente
                    binding.detailNameTextview.text = itemName

                    // Carica l'immagine dell'oggetto utilizzando Picasso e la visualizza nell'interfaccia utente
                    Picasso.get().load(itemUrl).into(binding.detailImageviewImageview)

                    // Imposta i dettagli dell'oggetto nell'interfaccia utente
                    binding.detailDetailsTextview.text = itemDetail
                }
            }
        }

        // Aggiunge un callback per la gestione del pulsante back premuto
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Chiude l'attività corrente
                finish()

                // Applica una transizione di animazione personalizzata
                overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right)
            }
        }
        //back a schermo chiama callback per tornare indietro
        binding.backButton.setOnClickListener {
            callback.handleOnBackPressed()
        }
        // Collega il callback al pulsante di back fisico
        onBackPressedDispatcher.addCallback(this, callback)
    }
}
