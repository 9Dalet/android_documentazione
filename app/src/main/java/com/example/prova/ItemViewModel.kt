package com.example.prova

import com.google.gson.annotations.SerializedName

class ItemViewModel (
    @SerializedName("name") //nome da api
    val itemName: String, // Nome dell'oggetto

    @SerializedName("image") //nome da api
    val itemImageUrl: String, // URL dell'immagine dell'oggetto

    @SerializedName("details") //nome da api
    val itemDetail: String // Dettagli dell'oggetto
)
