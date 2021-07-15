package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.GenreResponse
import com.sentinel.data.datasource.remote.responses.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface GenreService {

    @GET("/genre/movie/list?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieGenres(): Response<GenreResponse>

    @GET("/genre/tv/list?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getTVGenres(): Response<GenreResponse>
}
