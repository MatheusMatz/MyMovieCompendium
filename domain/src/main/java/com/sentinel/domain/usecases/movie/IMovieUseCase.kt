package com.sentinel.domain.usecases.movie

import com.sentinel.domain.dtos.MovieDTO

interface IMovieUseCase {

    suspend fun loadTrendiesMovies(): List<MovieDTO>
    suspend fun loadPopularMovies(): List<MovieDTO>
}
