package de.sample.coldtea.recyclerviewanimations.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import de.sample.coldtea.recyclerviewanimations.model.TextData
import de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates.DelegateTextItem

class RecViewItemDiffCallback: DiffUtil.ItemCallback<TextData>() {
    override fun areItemsTheSame(oldItem: TextData, newItem: TextData): Boolean =
        oldItem.timestamp == newItem.timestamp

    override fun areContentsTheSame(oldItem: TextData, newItem: TextData): Boolean =
        oldItem == newItem
}