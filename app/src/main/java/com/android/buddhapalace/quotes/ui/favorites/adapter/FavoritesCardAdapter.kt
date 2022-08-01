package com.android.buddhapalace.quotes.ui.favorites.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.buddhapalace.quotes.R
import com.android.data.database.entity.quotes.Quote

class FavoritesCardAdapter(
    private val listener: CallbackFavoritesCardAdapter
) : RecyclerView.Adapter<FavoritesCardAdapter.ViewHolder>() {

    private var quotes: MutableList<Quote> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.favorite_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]
        holder.text.text = quote.languages.ru.quote
        holder.date.text = quote.date
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    fun setQuotes(quotes: List<Quote>) {
        this.quotes.clear()
        this.quotes.addAll(quotes)
        notifyDataSetChanged()
    }

    fun deleteItem(id: Int) {
        this.quotes.removeAt(id)
        notifyItemChanged(id)
    }

    fun getTaskForPosition(pos: Int): Quote {
        return this.quotes[pos]
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.text_item)
        val date: TextView = view.findViewById(R.id.date)


    }

}