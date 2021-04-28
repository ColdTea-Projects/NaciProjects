package de.sample.coldtea.sampleretrofitapp.users.repository.model


import com.google.gson.annotations.SerializedName

data class UserResponseRepo(
    @SerializedName("data")
    var userRepo: List<UserRepo>?,
    @SerializedName("page")
    var page: Int?,
    @SerializedName("per_page")
    var perPage: Int?,
    @SerializedName("supportRepo")
    var supportRepo: SupportRepo?,
    @SerializedName("total")
    var total: Int?,
    @SerializedName("total_pages")
    var totalPages: Int?
)