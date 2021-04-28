package de.sample.coldtea.sampleretrofitapp.users.repository

import org.koin.java.KoinJavaComponent.inject
import retrofit2.Retrofit

class UsersRepository(retrofit: Retrofit) {
    private val usersApi by lazy { retrofit.create(UsersApi::class.java) }

    suspend fun getUsersResponse() = usersApi.getUsersResponse().getUserList()
}