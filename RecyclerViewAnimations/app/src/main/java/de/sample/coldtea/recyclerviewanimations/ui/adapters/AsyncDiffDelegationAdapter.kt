package de.sample.coldtea.recyclerviewanimations.ui.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.AdapterListUpdateCallback
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.hannesdorfmann.adapterdelegates4.AdapterDelegatesManager

abstract class AsyncDiffDelegationAdapter<T>(itemCallback: DiffUtil.ItemCallback<T>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    @Suppress("LeakingThis")
    protected val helper = AsyncListDiffer<T>(
        AdapterListUpdateCallback(this),
        AsyncDifferConfig.Builder(itemCallback).build()
    )

    protected val delegatesManager = AdapterDelegatesManager<List<T>>()

    fun submitList(list: List<T>) {
        helper.submitList(list)
    }

    fun getLastIndex(): Int = helper.currentList.lastIndex

    protected fun getItem(position: Int): T = helper.currentList[position]

    override fun getItemCount(): Int = helper.currentList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        delegatesManager.onCreateViewHolder(parent, viewType)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegatesManager.onBindViewHolder(helper.currentList, position, holder, null)
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int,
        payloads: List<*>
    ) {
        delegatesManager.onBindViewHolder(helper.currentList, position, holder, payloads)
    }

    override fun getItemViewType(position: Int): Int {
        return delegatesManager.getItemViewType(helper.currentList, position)
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewRecycled(holder)
    }

    override fun onFailedToRecycleView(holder: RecyclerView.ViewHolder): Boolean {
        return delegatesManager.onFailedToRecycleView(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewAttachedToWindow(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        delegatesManager.onViewDetachedFromWindow(holder)
    }
}