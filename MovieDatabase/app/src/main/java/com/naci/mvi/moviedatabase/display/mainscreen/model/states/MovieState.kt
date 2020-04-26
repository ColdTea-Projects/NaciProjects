package com.naci.mvi.moviedatabase.mainscreen.model.states

import com.naci.mvi.moviedatabase.mainscreen.model.dataobjects.Movie

sealed class MovieState {
    object LoadingState: MovieState()
    data class DataState(val data: List<Movie>): MovieState()
    data class ErrorState(val data: String): MovieState()
    data class ConfirmationState(val data: Movie): MovieState()
    object FinishState: MovieState()
}