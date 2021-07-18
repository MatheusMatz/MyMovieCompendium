package com.sentinel.data.datasource.remote.service

import com.sentinel.data.datasource.remote.responses.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieService {

    @GET("movie/{id}?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieDetail(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/account_states?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieAccountDetail(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/alternative_titles?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieAlternativeTitles(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/changes?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieChanges(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/credits?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieCredits(@Path("id") id: Long): Response<MovieResponse>

    @GET("movie/{id}/images?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieImages(@Path("id") id: Long): Response<ImagesResponse>

    @GET("movie/{id}/keywords?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieKeyWord(@Path("id") id: Long): Response<KeywordResponse>

    @GET("movie/{id}/recommendations?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieRecommendations(@Path("id") id: Long): Response<MovieListResponse>

    @GET("movie/{id}/reviews?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieReviews(@Path("id") id: Long): Response<ReviewResponse>

    @GET("movie/{id}/similar?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieSimilar(@Path("id") id: Long): Response<MovieListResponse>

    @GET("movie/{id}/videos?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieVideos(@Path("id") id: Long): Response<VideoResponse>

    @GET("movie/{id}/watch/providers?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMovieProviders(@Path("id") id: Long): Response<ProviderResponse>

    @GET("movie/now_playing?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMoviesPlayingNow(): Response<MovieListResponse>

    @GET("movie/top_rated?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMoviesTopRates(): Response<MovieListResponse>

    @GET("movie/upcoming?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMoviesUpcoming(): Response<MovieListResponse>

    @GET("movie/popular?api_key=3c46535b05afcf2269dd861105b19684")
    suspend fun getMoviesPopular(): Response<MovieListResponse>
}
