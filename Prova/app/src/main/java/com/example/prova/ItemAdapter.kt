package com.example.prova

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.danielegiarratano.prova.R
import com.squareup.picasso.Picasso

class ItemAdapter(private val list: List<ItemViewModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    // Classe ViewHolder che rappresenta un elemento dell'elenco nella RecyclerView
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageview: ImageView = itemView.findViewById(R.id.home_item_imageview)
        val textview: TextView = itemView.findViewById(R.id.home_item_textview)
    }

    // Metodo chiamato quando viene creato un nuovo ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // Infla il layout dell'elemento della lista
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false))
    }

    // Restituisce il numero di elementi nella lista
    override fun getItemCount(): Int {
        return list.size
    }

    // Metodo chiamato quando è necessario collegare i dati a un ViewHolder specifico nella posizione specificata
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = list[position]

        // Imposta il nome dell'oggetto nella TextView
        holder.textview.text = item.itemName

        // Carica l'immagine dell'oggetto utilizzando Picasso e la visualizza nell'ImageView
        Picasso.get().load(item.itemImageUrl).into(holder.imageview)

        // Gestisce il clic sull'elemento della lista
        holder.itemView.setOnClickListener {
            manageOnClick(holder.itemView.context, item)
        }
    }

    // Gestisce il clic sull'elemento della lista
    private fun manageOnClick(context: Context, item: ItemViewModel) {
        // Crea un intent per avviare l'attività di dettaglio
        val intent = Intent(context, DetailActivity::class.java)

        // Passa i dati dell'oggetto all'attività di dettaglio utilizzando extra nell'intent
        intent.putExtra("name", item.itemName)
        intent.putExtra("url", item.itemImageUrl)
        intent.putExtra("details", item.itemDetail)

        // Avvia l'attività di dettaglio
        context.startActivity(intent)

        // Applica una transizione di animazione personalizzata all'avvio dell'attività di dettaglio
        (context as Activity).overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left)
    }
}
