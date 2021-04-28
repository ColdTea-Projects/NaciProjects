package de.sample.coldtea.sampleretrofitapp.users.repository.model


import com.google.gson.annotations.SerializedName

data class SupportRepo(
    @SerializedName("text")
    var text: String?,
    @SerializedName("url")
    var url: String?
)