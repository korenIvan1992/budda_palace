package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class DetailsQuoteDto(
    @JsonProperty
    @SerializedName("quote")
    var quote: String,
    @JsonProperty
    @SerializedName("source")
    var source: String
)
