package de.sample.coldtea.sampleretrofitapp.users.adapter.delegate

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import de.sample.coldtea.sampleretrofitapp.databinding.LayoutLoadingSpinnerDelegateBinding
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.BaseUserListItem
import de.sample.coldtea.sampleretrofitapp.users.adapter.model.UserLoadingSpinnerItem

class DelegateLoadingSpinner :
    AbsListItemAdapterDelegate<UserLoadingSpinnerItem, BaseUserListItem, DelegateLoadingSpinner.SpinnerItemAdapterDelegateViewHolder>() {
    override fun isForViewType(item: BaseUserListItem, items: MutableList<BaseUserListItem>, position: Int) = item is UserLoadingSpinnerItem

    override fun onCreateViewHolder(parent: ViewGroup): SpinnerItemAdapterDelegateViewHolder =
        SpinnerItemAdapterDelegateViewHolder(
            LayoutLoadingSpinnerDelegateBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ),
                parent,
                false
            )
        )


    override fun onBindViewHolder(item: UserLoadingSpinnerItem, holder: SpinnerItemAdapterDelegateViewHolder, payloads: MutableList<Any>) {
        holder.bind()
    }

    class SpinnerItemAdapterDelegateViewHolder(
        private val binding: LayoutLoadingSpinnerDelegateBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {}
    }
}