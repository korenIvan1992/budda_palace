package com.android.data.utils.converter

import com.android.data.database.entity.quotes.Languages
import com.android.data.database.entity.quotes.Quote
import com.android.data.network.model.QuotesDto
import java.math.BigDecimal

object ConverterQuotes {

    fun convertQuotes(listDto: List<QuotesDto>): List<Quote> {
        val list = mutableListOf<Quote>()
        listDto.forEach {
            val quote = Quote(
                id = it.id.toLong(),
                languages = Languages(it.languages.en, it.languages.ru),
                date = "September 12th",
                like = false
            )
            list.add(quote)
        }
        return list
    }
}