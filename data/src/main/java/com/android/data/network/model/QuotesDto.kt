package com.android.data.network.model

import com.fasterxml.jackson.annotation.JsonProperty
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class QuotesDto(
    @JsonProperty
    @SerializedName("id")
    var id: String,
    @JsonProperty
    @SerializedName("languages")
    var languages: LanguagesDto

) : Serializable