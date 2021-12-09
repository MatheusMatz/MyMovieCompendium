package com.sentinel.data.datasource.remote.datasources

import com.sentinel.data.datasource.remote.BaseDataSource
import com.sentinel.data.datasource.remote.service.GenreService
import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.datasource.remote.service.TrendyService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(
    private val movieService: MovieService,
    private val trendyService: TrendyService,
) : BaseDataSource() {

    suspend fun fetchMovieDetail(movieId: Long) =
        getResult { movieService.getMovieDetail(movieId) }

    suspend fun fetchMovieAccountDetail(movieId: Long) =
        getResult { movieService.getMovieAccountDetail(movieId) }

    suspend fun fetchMovieAlternativeTitles(movieId: Long) =
        getResult { movieService.getMovieAlternativeTitles(movieId) }

    suspend fun fetchMovieChanges(movieId: Long) =
        getResult { movieService.getMovieChanges(movieId) }

    suspend fun fetchMovieCredits(movieId: Long) =
        getResult { movieService.getMovieCredits(movieId) }

    suspend fun fetchMovieImages(movieId: Long) =
        getResult { movieService.getMovieImages(movieId) }

    suspend fun fetchMovieKeyWord(movieId: Long) =
        getResult { movieService.getMovieKeyWord(movieId) }

    suspend fun fetchMovieRecommendations(movieId: Long) =
        getResult { movieService.getMovieRecommendations(movieId) }

    suspend fun fetchMovieReviews(movieId: Long) =
        getResult { movieService.getMovieReviews(movieId) }

    suspend fun fetchMovieSimilar(movieId: Long) =
        getResult { movieService.getMovieSimilar(movieId) }

    suspend fun fetchMovieVideos(movieId: Long) =
        getResult { movieService.getMovieVideos(movieId) }

    suspend fun fetchMovieProviders(movieId: Long) =
        getResult { movieService.getMovieProviders(movieId) }

    suspend fun fetchMoviesPlayingNow() =
        getResult { movieService.getMoviesPlayingNow() }

    suspend fun fetchMoviesTopRates() =
        getResult { movieService.getMoviesTopRates() }

    suspend fun fetchMoviesUpcoming() =
        getResult { movieService.getMoviesUpcoming() }

    suspend fun fetchMoviesPopular() =
        getResult { movieService.getMoviesPopular() }

    suspend fun fetchTrendiesMovies() =
        getResult { trendyService.getDayTrendiesMovies() }
}
