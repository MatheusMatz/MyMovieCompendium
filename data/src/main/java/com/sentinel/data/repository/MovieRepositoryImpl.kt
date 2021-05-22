package com.sentinel.data.repository

import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.entities.MovieResponse
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val movieService: MovieService) :
    MovieRepository {

    override suspend fun fetchDayTrendiesMovies(): MovieResponse {
        return movieService.getDayTrendiesMovies()
    }
}
