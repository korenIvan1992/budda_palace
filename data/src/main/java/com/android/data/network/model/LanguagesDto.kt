package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

data class LanguagesDto(
    @JsonProperty
    @SerializedName("en")
    var en: DetailsQuoteDto,
    @JsonProperty
    @SerializedName("ru")
    var ru: DetailsQuoteDto
)
