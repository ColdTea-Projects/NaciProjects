package de.sample.coldtea.sampleretrofitapp.users.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import de.sample.coldtea.sampleretrofitapp.R
import de.sample.coldtea.sampleretrofitapp.databinding.LayoutUserDelegateBinding
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.BaseUserListItem
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UserDelegateItem
import de.sample.coldtea.sampleretrofitapp.users.model.User

class DelegateUserItem :
    AbsListItemAdapterDelegate<UserDelegateItem, BaseUserListItem, DelegateUserItem.UserItemAdapterDelegateViewHolder>() {
    override fun isForViewType(item: BaseUserListItem, items: MutableList<BaseUserListItem>, position: Int) = item is UserDelegateItem

    override fun onCreateViewHolder(parent: ViewGroup): UserItemAdapterDelegateViewHolder =
        UserItemAdapterDelegateViewHolder(
            LayoutUserDelegateBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )


    override fun onBindViewHolder(item: UserDelegateItem, holder: UserItemAdapterDelegateViewHolder, payloads: MutableList<Any>) {
        holder.bind(item)
    }

    class UserItemAdapterDelegateViewHolder(
        private val binding: LayoutUserDelegateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(userDelegateItem: UserDelegateItem) {
            binding.data = userDelegateItem
            Glide
                .with(binding.root.context)
                .load(userDelegateItem.avatar)
                .placeholder(R.drawable.account_profile_head)
                .circleCrop()
                .apply(RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(binding.userImage)
        }
    }
}