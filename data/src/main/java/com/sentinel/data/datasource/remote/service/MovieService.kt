package com.sentinel.data.datasource.remote.service

import com.sentinel.core.Resource
import com.sentinel.data.entities.MovieResponse
import retrofit2.http.GET

interface MovieService {

    @GET("trending/all/day?api_key=")
    suspend fun getDayTrendiesMovies(): MovieResponse

    @GET("trending/all/week?api_key=")
    suspend fun getWeekTrendiesMovies(): Resource<MovieResponse>
}
