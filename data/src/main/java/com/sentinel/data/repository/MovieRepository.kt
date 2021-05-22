package com.sentinel.data.repository

import com.sentinel.data.entities.MovieResponse

interface MovieRepository {

    suspend fun fetchDayTrendiesMovies():MovieResponse
}
