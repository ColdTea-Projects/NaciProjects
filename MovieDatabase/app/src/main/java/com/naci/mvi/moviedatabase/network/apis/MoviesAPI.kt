package com.naci.mvi.moviedatabase.network

import com.naci.mvi.moviedatabase.display.mainscreen.model.dataobjects.Movie
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesAPI {
    @GET("/movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") movieId: String
    ): Observable<Movie>
}