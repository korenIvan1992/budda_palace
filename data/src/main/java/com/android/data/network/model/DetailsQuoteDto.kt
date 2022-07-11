package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class DetailsQuoteDto(
    @JsonProperty(value = "quote")
    var quote: String,
    @JsonProperty(value = "source")
    var source: String
)
