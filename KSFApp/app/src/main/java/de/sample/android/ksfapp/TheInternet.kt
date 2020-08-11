package de.sample.android.ksfapp

import android.util.Log
import timber.log.Timber

class SearchEngine {
    lateinit var query: Query
    lateinit var websites: Array<WebSite>

    fun search(): List<WebSite> = with(query) {
        //use
        websites.filter {
            it.isDead == query.showDeadPages
        }.toMutableList()
            .apply {
                //configure
            sortType?.let {
                when (sortType) {
                    SortType.ALPHABETICAL ->
                        this.sortBy { it.address }
                    SortType.DATE ->
                        this.sortBy {
                            it.date
                        }
                }
            }
        }.apply {
                //configure
            if (maxPageNumber < this.size)
                this.removeAll(this.subList(maxPageNumber - 1, this.size - 1))
        }.also {
                //utilize
            Log.i("Website", "${it.size.toString()} search results found")
        }
    }

    fun blowUpIfEmpty() {
        TODO("Cuz we did not implement anything yet used the function!!")
    }

    fun logTheFullSize() {
        Log.i("Website", websites.size.toString())
    }
}

data class Query(val maxPageNumber: Int, val sortType: SortType?, val showDeadPages: Boolean)

data class WebSite(val isDead: Boolean, val address: String, val summary: String, val date: String)

enum class SortType {
    ALPHABETICAL,
    DATE
}