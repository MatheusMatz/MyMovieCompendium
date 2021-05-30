package com.sentinel.data.datasource.remote.datasources

import com.sentinel.data.datasource.remote.BaseDataSource
import com.sentinel.data.datasource.remote.service.MovieService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val movieService: MovieService) :
    BaseDataSource() {

    suspend fun fetchTrendiesMovies() = getResult { movieService.getDayTrendiesMovies() }
}
