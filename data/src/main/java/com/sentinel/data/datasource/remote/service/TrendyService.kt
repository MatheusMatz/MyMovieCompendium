package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface TrendyService {

    @GET("trending/all/day?api_key=")
    suspend fun getDayTrendiesMovies(): Response<MovieListResponse>

    @GET("trending/all/week?api_key=")
    suspend fun getWeekTrendiesMovies(): Response<MovieListResponse>
}
