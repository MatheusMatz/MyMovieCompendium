package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.MovieResponse
import retrofit2.http.GET

interface MovieService {

    @GET("trending/all/day?api_key=")
    suspend fun getDayTrendiesMovies(): MovieResponse

    @GET("trending/all/week?api_key=")
    suspend fun getWeekTrendiesMovies(): MovieResponse
}
