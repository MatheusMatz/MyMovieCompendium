package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/{id}?api_key=")
    suspend fun getMovieDetail(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/account_states?api_key=")
    suspend fun getMovieAccountDetail(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/alternative_titles?api_key=")
    suspend fun getMovieAlternativeTitles(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/changes?api_key=")
    suspend fun getMovieChanges(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/credits?api_key=")
    suspend fun getMovieCredits(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of images
    // @GET("/movie/{id}/images?api_key=")
    // suspend fun getMovieImages(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of keywords
    // @GET("/movie/{id}/keywords?api_key=")
    // suspend fun getMovieKeyWord(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of recommendations
    // @GET("/movie/{id}/recommendations?api_key=")
    // suspend fun getMovieRecommendations(@Path("id") id: Long): Response<MovieResponse>



}
