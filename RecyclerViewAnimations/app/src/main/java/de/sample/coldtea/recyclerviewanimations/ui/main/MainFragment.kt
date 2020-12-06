package de.sample.coldtea.recyclerviewanimations.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import de.sample.coldtea.recyclerviewanimations.databinding.MainFragmentBinding
import de.sample.coldtea.recyclerviewanimations.extensions.orZero
import de.sample.coldtea.recyclerviewanimations.ui.adapters.AdapterRecViewItem
import de.sample.coldtea.recyclerviewanimations.ui.adapters.delegates.DelegateTextItem
import de.sample.coldtea.recyclerviewanimations.ui.listeners.IncomingItemObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel by viewModels<MainViewModel>()

    private lateinit var binding: MainFragmentBinding

    private val messagesAdapter by lazy {
        AdapterRecViewItem(DelegateTextItem())
    }

    private val onItemsChangedAdapterDataObserver by lazy {
        IncomingItemObserver(::onItemRangeInserted)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        messagesAdapter.unregisterAdapterDataObserver(onItemsChangedAdapterDataObserver)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = MainFragmentBinding.inflate(inflater, container, false)
        viewModel.list.observe(viewLifecycleOwner){
            messagesAdapter.submitList(it.toList())
        }
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = messagesAdapter
            messagesAdapter.registerAdapterDataObserver(onItemsChangedAdapterDataObserver)

//            itemAnimator = null

            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                }

                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                    if(newState == RecyclerView.SCROLL_STATE_IDLE){
                        val layoutManager: LinearLayoutManager? = binding.recyclerViewList.layoutManager as LinearLayoutManager
                        val lastItemPosition = layoutManager?.findLastCompletelyVisibleItemPosition().orZero()
                        val lastIndex = viewModel.list.value?.lastIndex.orZero()
                        if (lastItemPosition == lastIndex){
                            viewModel.loadMore()
                        }
                    }
                }
            })
        }

        viewModel.loadMore()
    }

    private fun onItemRangeInserted() {
        binding.recyclerViewList.scrollToPosition(viewModel.list.value?.lastIndex.orZero())
    }

}