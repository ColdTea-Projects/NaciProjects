package de.sample.coldtea.sampleretrofitapp.shared.koin

import de.sample.coldtea.sampleretrofitapp.shared.network.APIClient
import de.sample.coldtea.sampleretrofitapp.users.repository.UsersRepository
import org.koin.dsl.module
import kotlin.math.sin

val networkModule = module {
    single {
        APIClient().getRetrofitClient()
    }

    single {
        UsersRepository(get())
    }
}