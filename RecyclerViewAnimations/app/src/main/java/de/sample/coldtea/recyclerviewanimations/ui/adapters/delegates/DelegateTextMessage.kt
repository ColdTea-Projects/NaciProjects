package de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AbsListItemAdapterDelegate
import de.sample.coldtea.recyclerviewanimations.databinding.MessageboxLayoutBinding
import de.sample.coldtea.recyclerviewanimations.model.TextData
import kotlin.random.Random

class DelegateTextMessage :
    AbsListItemAdapterDelegate<TextData, TextData, DelegateTextMessage.TextItemAdapterDelegateViewHolder>() {

    override fun isForViewType(
        item: TextData,
        items: MutableList<TextData>,
        position: Int
    ) = item is TextData

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
            binding.messageText.setBackgroundColor(
                Color.rgb(
                    Random.nextInt(255),
                    Random.nextInt(255),
                    Random.nextInt(255))
            )
        }
    }
}