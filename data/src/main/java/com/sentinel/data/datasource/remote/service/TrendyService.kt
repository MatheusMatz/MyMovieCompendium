package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.MovieListResponse
import retrofit2.Response
import retrofit2.http.GET

interface TrendyService {

    @GET("trending/all/day?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getDayTrendiesMovies(): Response<MovieListResponse>

    @GET("trending/all/week?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getWeekTrendiesMovies(): Response<MovieListResponse>
}
