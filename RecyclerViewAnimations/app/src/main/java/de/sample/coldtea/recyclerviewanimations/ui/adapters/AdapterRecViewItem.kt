package de.sample.coldtea.recyclerviewanimations.ui.adapters

import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegate
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import de.sample.coldtea.recyclerviewanimations.model.TextData
import de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates.DelegateTextItem

class AdapterRecViewItem(delegate: DelegateTextItem) : AsyncDiffDelegationAdapter<TextData>(RecViewItemDiffCallback()) {
    init {
        delegatesManager.addDelegate(delegate)
    }
}
