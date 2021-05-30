package com.sentinel.data.repository

import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.datasource.remote.responses.MovieResponse
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieService: MovieService,
    private val movieDao: MovieDao
) : MovieRepository {

    override suspend fun fetchDayTrendiesMovies(): MovieResponse {
        return movieService.getDayTrendiesMovies()
    }
}
