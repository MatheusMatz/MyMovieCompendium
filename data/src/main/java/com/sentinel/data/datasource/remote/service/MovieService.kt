package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/{id}?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieDetail(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/account_states?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieAccountDetail(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/alternative_titles?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieAlternativeTitles(@Path("id") id : Long): Response<MovieResponse>

    @GET("/movie/{id}/changes?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieChanges(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/credits?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieCredits(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of images
    // @GET("/movie/{id}/images?api_key=3c46535b05afcf2269dd861105b19684")
    // suspend fun getMovieImages(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of keywords
    // @GET("/movie/{id}/keywords?api_key=3c46535b05afcf2269dd861105b19684")
    // suspend fun getMovieKeyWord(@Path("id") id: Long): Response<MovieResponse>

    //TODO Change response to list of recommendations
    // @GET("/movie/{id}/recommendations?api_key=3c46535b05afcf2269dd861105b19684")
    // suspend fun getMovieRecommendations(@Path("id") id: Long): Response<MovieResponse>



}
