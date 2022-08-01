package com.android.buddhapalace.quotes.ui.quotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.buddhapalace.quotes.R
import com.android.buddhapalace.quotes.ui.allglobal.extentions.makeGone
import com.android.data.database.entity.quotes.Quote
import java.util.*

class CardQuoteAdapter(
    private var quotes: LinkedList<Quote>,
    private val listener: (CallbackCardAdapter)
) : RecyclerView.Adapter<CardQuoteAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater.inflate(R.layout.item_card, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val quote = quotes[position]

        if (quote.like)
            holder.likeImage.setImageResource(R.drawable.like_active)
        else
            holder.likeImage.setImageResource(R.drawable.like)

        holder.date.text = quote.date
        holder.quoteText.text = quote.languages.ru.quote
        holder.autorName.text = quote.languages.en.quote
        holder.itemView.setOnClickListener { v ->
        }

        if (position == 0)
            holder.back.makeGone()

        if (position == quotes.size - 1)
            holder.early.makeGone()

        holder.likeButton.setOnClickListener {
            if (!quote.like)
                holder.likeImage.setImageResource(R.drawable.like_active)
            else
                holder.likeImage.setImageResource(R.drawable.like)

            quote.like = !quote.like
            listener.like(quote)
        }
        holder.backButton.setOnClickListener {
            listener.back()
        }
        holder.earlyButton.setOnClickListener {
            listener.early()
        }
    }

    override fun getItemCount(): Int {
        return quotes.size
    }

    fun updateElement(quote: Quote) {
        quotes.forEachIndexed { index, it ->
            if (it.id == quote.id){
                quotes[index] = quote
                notifyItemChanged(index)
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.date_title)
        val quoteText: TextView = view.findViewById(R.id.quote_text)
        val autorName: TextView = view.findViewById(R.id.autor_name)
        val likeButton: View = view.findViewById(R.id.like_button)
        val likeImage: ImageView = view.findViewById(R.id.like)
        val earlyButton: View = view.findViewById(R.id.early_button)
        val backButton: View = view.findViewById(R.id.back_button)
        val back: ImageView = view.findViewById(R.id.back)
        val early: ImageView = view.findViewById(R.id.early)

    }

}