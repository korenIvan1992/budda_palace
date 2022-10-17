package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class LanguagesDto(
    @JsonProperty(value = "en")
    var en: DetailsQuoteDto,
    @JsonProperty(value = "ru")
    var ru: DetailsQuoteDto
)
