package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.GenreListResponse
import retrofit2.Response
import retrofit2.http.GET

interface GenreService {

    @GET("genre/movie/list?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieGenres(): Response<GenreListResponse>

    @GET("genre/tv/list?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getTVGenres(): Response<GenreListResponse>
}
