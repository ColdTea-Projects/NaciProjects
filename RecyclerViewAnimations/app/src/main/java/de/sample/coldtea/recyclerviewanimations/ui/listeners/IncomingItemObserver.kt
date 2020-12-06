package de.sample.coldtea.recyclerviewanimations.ui.listeners

import androidx.recyclerview.widget.RecyclerView

internal class IncomingItemObserver(private val onInserted: (() -> Unit)?) : RecyclerView.AdapterDataObserver() {

    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        onInserted?.invoke()
    }

}