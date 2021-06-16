package com.android.data.datasource.local

import android.content.Context
import com.android.data.database.dao.quotes.QuotesDao
import com.android.data.database.entity.quotes.Quote

class QuotesLocalDataSource(private val context: Context, quotesDao: QuotesDao) {

    fun getQuotes(): List<Quote> {
        val quotes = ArrayList<Quote>()
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 18th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center.B"
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "October 21th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = true,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "November 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = false,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        quotes.add(
            Quote(
                id = 0,
                like = true,
                autor = "Buddha & Love: Timeless Wisdom for Modern Relationships (2012)",
                date = "September 15th",
                text = "A generous relationship rarely knows dramas. One is happy when the partner is happy. And one is happy when growing on three levels: on the physical level, which gives love, material things, and protection; on the inner level — through compassion and wisdom — which provides the motivation for development; and on a deep-lying, secret level where both partners enrich themselves with the qualities of the other and increasingly find their center."
            )
        )
        return quotes
    }

}