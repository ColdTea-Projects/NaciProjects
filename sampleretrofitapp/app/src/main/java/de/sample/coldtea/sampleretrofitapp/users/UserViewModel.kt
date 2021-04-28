package de.sample.coldtea.sampleretrofitapp.users

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UserDelegateItem
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UserLoadingSpinnerItem
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UsersListViewStates
import de.sample.coldtea.sampleretrofitapp.users.repository.UsersRepository
import kotlinx.coroutines.launch
import org.koin.java.KoinJavaComponent.inject
import timber.log.Timber

class UserViewModel : ViewModel() {
    private val usersRepository by inject(UsersRepository::class.java)

    /**
     * LiveData used for updating the Fragment
     */
    private val _viewState = MutableLiveData<UsersListViewStates>()

    internal val viewState: LiveData<UsersListViewStates>
        get() = _viewState

    fun loadUsers() {
        _viewState.value = UsersListViewStates.Loading(listOf(UserLoadingSpinnerItem))
        viewModelScope.launch {
            val result = usersRepository.getUsersResponse().map {
                UserDelegateItem(
                    it.avatar,
                    it.email,
                    it.firstName,
                    it.lastName
                )
            }

            _viewState.value = UsersListViewStates.LoadingSuccess(result)
            Timber.i(result.toString())
        }
    }
}