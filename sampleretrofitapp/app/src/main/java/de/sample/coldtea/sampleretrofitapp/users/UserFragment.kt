package de.sample.coldtea.sampleretrofitapp.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import de.sample.coldtea.sampleretrofitapp.databinding.UserFragmentBinding
import de.sample.coldtea.sampleretrofitapp.users.adapter.AdapterUser
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.BaseUserListItem
import de.sample.coldtea.sampleretrofitapp.users.model.User
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UsersListViewStates
import okhttp3.internal.notify

class UserFragment : Fragment() {
    private lateinit var binding: UserFragmentBinding
    private val usersAdapter = AdapterUser()

    companion object {
        fun newInstance() = UserFragment()
    }

    private val viewModel by viewModels<UserViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = UserFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initMessagesRecyclerView()
        initViewStateObservers()

        viewModel.loadUsers()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel.testUsersResponse()
    }

    private fun initMessagesRecyclerView() = binding.usersList.apply {
        layoutManager = LinearLayoutManager(requireContext())
        adapter = usersAdapter
    }

    fun initViewStateObservers() {
        viewModel
        .viewState
        .observe(viewLifecycleOwner){
            when(it){
                is UsersListViewStates.Loading -> onLoading(it.userList)
                is UsersListViewStates.LoadingSuccess -> onLoadingSuccess(it.userList)
                else -> {}
            }
        }
    }

    private fun onLoading(users:List<BaseUserListItem>){
        usersAdapter.items = users
        usersAdapter.notifyDataSetChanged()
    }

    private fun onLoadingSuccess(users:List<BaseUserListItem>){
        usersAdapter.items = users
        usersAdapter.notifyDataSetChanged()
    }
}
