package de.sample.coldtea.sampleretrofitapp.users.repository

import de.sample.coldtea.sampleretrofitapp.users.repository.model.UserResponseRepo
import io.reactivex.Single
import retrofit2.http.GET

interface UsersApi {

    @GET("api/users")
    suspend fun getUsersResponse(): UserResponseRepo

}