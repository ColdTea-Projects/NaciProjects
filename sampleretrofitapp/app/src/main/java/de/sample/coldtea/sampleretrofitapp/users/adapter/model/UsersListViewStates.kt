package de.sample.coldtea.sampleretrofitapp.users.adapter.model

import de.sample.coldtea.sampleretrofitapp.users.model.User

sealed class UsersListViewStates{

    data class Loading(val userList: List<BaseUserListItem>): UsersListViewStates()
    data class LoadingSuccess(val userList: List<BaseUserListItem>): UsersListViewStates()

}
