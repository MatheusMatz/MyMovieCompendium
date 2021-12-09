package com.sentinel.data.repository.movie

import com.sentinel.data.models.Movie

interface IMovieRepository {

    suspend fun fetchDayTrendiesMovies(): List<Movie>
    suspend fun fetchPopularMovies(): List<Movie>
}
