package com.sentinel.domain.usecases

import com.sentinel.domain.dtos.MovieDTO

interface MovieUseCase {

    suspend fun loadTrendiesMovies(): List<MovieDTO>
    suspend fun loadPopularMovies(): List<MovieDTO>
}
