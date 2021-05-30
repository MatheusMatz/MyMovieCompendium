package com.sentinel.data.repository

import com.sentinel.data.models.Movie

interface MovieRepository {

    suspend fun fetchDayTrendiesMovies(): List<Movie>
}
