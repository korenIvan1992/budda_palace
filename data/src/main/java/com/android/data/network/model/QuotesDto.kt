package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@JsonIgnoreProperties(ignoreUnknown = true)
data class QuotesDto(
    @JsonProperty(value = "id")
    var id: String,
    @JsonProperty(value = "languages")
    var languages: LanguagesDto

)