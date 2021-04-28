package de.sample.coldtea.sampleretrofitapp.users.repository

import de.sample.coldtea.sampleretrofitapp.users.model.User
import de.sample.coldtea.sampleretrofitapp.users.repository.model.UserRepo
import de.sample.coldtea.sampleretrofitapp.users.repository.model.UserResponseRepo

fun UserResponseRepo.getUserList(): List<User> = this.userRepo?.map {
    User(
        it.avatar,
        it.email,
        it.firstName,
        it.id,
        it.lastName
    )
}?: listOf()