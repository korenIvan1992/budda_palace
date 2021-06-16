package com.android.buddhapalace.quotes.ui.quotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.buddhapalace.quotes.R
import com.android.data.database.entity.quotes.Quote
import timber.log.Timber

class CardStackAdapter(
    private var quotes: List<Quote> = emptyList()
) : RecyclerView.Adapter<CardStackAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.date.text = quote.date
        holder.quoteText.text = quote.text
        holder.autorName.text = quote.autor
        holder.itemView.setOnClickListener { v ->
        }

        holder.likeButton.setOnClickListener {
            Timber.d("like button")
        }
        holder.back.setOnClickListener {
            Timber.d("back button")
        }
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    fun setSpots(spots: List<Quote>) {
        this.quotes = spots
    }

    fun getSpots(): List<Quote> {
        return quotes
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.date_title)
        val quoteText: TextView = view.findViewById(R.id.quote_text)
        val autorName: TextView = view.findViewById(R.id.autor_name)
        val likeButton: ImageView = view.findViewById(R.id.like_button)
        val back: ImageView = view.findViewById(R.id.back)

    }

}