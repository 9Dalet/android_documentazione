package com.example.prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prova.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inizializza il binding per l'attività principale utilizzando il layoutInflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Apre il file JSON di risorse denominato "qualcosa"
        val json = resources.openRawResource(R.raw.qualcosa)

        // Crea un oggetto TypeToken che rappresenta una lista di oggetti ItemViewModel
        val typeToken = object : TypeToken<List<ItemViewModel>>() {}.type

        // Legge il contenuto del file JSON e lo memorizza nella variabile text
        val text = json.bufferedReader().use {
            it.readText()
        }

        // Gson per deserializzare il JSON nella lista di oggetti ItemViewModel
        val itemsList = Gson().fromJson<List<ItemViewModel>>(text, typeToken)

        // Imposta un LinearLayoutManager come layout manager per la RecyclerView
        binding.homeItemRecyclerview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // Imposta un adapter personalizzato (ItemAdapter) per la RecyclerView
        binding.homeItemRecyclerview.adapter = ItemAdapter(itemsList)
    }
}
