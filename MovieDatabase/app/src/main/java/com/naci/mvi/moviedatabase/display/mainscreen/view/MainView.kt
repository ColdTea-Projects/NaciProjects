package com.naci.mvi.moviedatabase.mainscreen.view

import com.naci.mvi.moviedatabase.mainscreen.model.states.MovieState

interface MainView{
    fun displayMoviesIntent()
    fun render(state: MovieState)
}