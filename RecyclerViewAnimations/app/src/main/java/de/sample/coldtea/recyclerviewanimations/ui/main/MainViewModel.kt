package de.sample.coldtea.recyclerviewanimations.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import de.sample.coldtea.recyclerviewanimations.model.TextData
import de.sample.coldtea.recyclerviewanimations.extensions.getRandomString
import java.util.Calendar

class MainViewModel : ViewModel() {

    private val _list = MutableLiveData<MutableList<TextData>>()

    private val now: Long
        get() {
            val calendar = Calendar.getInstance()
            return calendar.timeInMillis
        }

    val list: LiveData<MutableList<TextData>>
        get() = _list

    fun loadMore() {
        val newList = _list.value?: mutableListOf()

        for (i in 0 until 5) {
            newList.add(TextData(TextData.fakeListOfText.getRandomString(), now))
        }

        _list.value = newList
    }
}