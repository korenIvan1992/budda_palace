package com.android.data.database.entity.quotes

import com.android.data.network.model.DetailsQuoteDto
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Languages(
    @JsonProperty(value = "en")
    var en: DetailsQuoteDto,
    @JsonProperty(value = "ru")
    var ru: DetailsQuoteDto
)
