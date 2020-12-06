package de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import de.sample.coldtea.recyclerviewanimations.databinding.MessageboxLayoutBinding
import de.sample.coldtea.recyclerviewanimations.model.TextData

class DelegateTextItem :
    AbsListItemAdapterDelegate<TextData, TextData, DelegateTextItem.TextItemAdapterDelegateViewHolder>() {

    override fun isForViewType(
        item: TextData,
        items: MutableList<TextData>,
        position: Int
    ) = true

    override fun onBindViewHolder(
        item: TextData,
        holderOffer: TextItemAdapterDelegateViewHolder,
        payloads: MutableList<Any>
    ) {
        holderOffer.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup) =
        TextItemAdapterDelegateViewHolder(
            MessageboxLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    class TextItemAdapterDelegateViewHolder(
        private val binding: MessageboxLayoutBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(textData: TextData) {
            binding.text = "${textData.timestamp} - ${textData.text}"
        }
    }
}