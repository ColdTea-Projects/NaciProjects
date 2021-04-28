package de.sample.coldtea.sampleretrofitapp.users.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import de.sample.coldtea.sampleretrofitapp.users.adapter.delegate.DelegateLoadingSpinner
import de.sample.coldtea.sampleretrofitapp.users.adapter.delegate.DelegateUserItem
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.BaseUserListItem

class AdapterUser : ListDelegationAdapter<List<BaseUserListItem>>(
    DelegateUserItem(),
    DelegateLoadingSpinner())