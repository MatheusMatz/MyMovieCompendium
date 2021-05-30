package com.sentinel.data.repository

import com.sentinel.data.datasource.remote.responses.MovieResponse

interface MovieRepository {

    suspend fun fetchDayTrendiesMovies(): MovieResponse
}
