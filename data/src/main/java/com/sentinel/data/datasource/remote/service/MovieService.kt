package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("/movie/{id}?api_key=")
    suspend fun getMovieDetail(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/account_states?api_key=")
    suspend fun getMovieAccountDetail(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/alternative_titles?api_key=")
    suspend fun getMovieAlternativeTitles(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/changes?api_key=")
    suspend fun getMovieChanges(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/credits?api_key=")
    suspend fun getMovieCredits(@Path("id") id: Long): Response<MovieResponse>

    @GET("/movie/{id}/images?api_key=")
    suspend fun getMovieImages(@Path("id") id: Long): Response<ImagesResponse>

    @GET("/movie/{id}/keywords?api_key=")
    suspend fun getMovieKeyWord(@Path("id") id: Long): Response<KeywordResponse>

    @GET("/movie/{id}/recommendations?api_key=")
    suspend fun getMovieRecommendations(@Path("id") id: Long): Response<MovieListResponse>

    @GET("/movie/{id}/reviews?api_key=")
    suspend fun getMovieReviews(@Path("id") id: Long): Response<ReviewResponse>

    @GET("/movie/{id}/similar?api_key=")
    suspend fun getMovieSimilar(@Path("id") id: Long): Response<MovieListResponse>

    @GET("/movie/{id}/videos?api_key=")
    suspend fun getMovieVideos(@Path("id") id: Long): Response<VideoResponse>

    @GET("/movie/{id}/watch/providers?api_key=")
    suspend fun getMovieProviders(@Path("id") id: Long): Response<ProviderResponse>

    @GET("/movie/now_playing?api_key=")
    suspend fun getMoviesPlayingNow(): Response<MovieListResponse>

    @GET("/movie/top_rated?api_key=")
    suspend fun getMoviesTopRates(): Response<MovieListResponse>

    @GET("/movie/upcoming?api_key=")
    suspend fun getMoviesUpcoming(): Response<MovieListResponse>

}
