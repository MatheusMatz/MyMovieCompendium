package com.sentinel.data.repository

import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.performGetOperation
import com.sentinel.data.datasource.remote.datasources.MovieRemoteDataSource
import com.sentinel.data.mappers.MovieEntityMapper
import com.sentinel.data.mappers.MovieMapper
import com.sentinel.data.models.Movie
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieDao: MovieDao,
    private val movieEntityMapper: MovieEntityMapper,
    private val movieMapper: MovieMapper,
) : MovieRepository {

    private var trendiesMovies: List<Movie> = listOf()

    override suspend fun fetchDayTrendiesMovies(): List<Movie> {

        val movies = movieDao.getTrendiesMovies(true)

        return if (!trendiesMovies.isNullOrEmpty()) {
            trendiesMovies = movieMapper.transform(movies)
            trendiesMovies
        } else {
            val fetchTrendiesMovies = movieRemoteDataSource.fetchTrendiesMovies()
            val transform = movieEntityMapper.transform(fetchTrendiesMovies.data?.results)
            movieDao.insertMovies(transform)
            val moviesSaved = movieDao.getTrendiesMovies(true)
            trendiesMovies = movieMapper.transform(moviesSaved)
            trendiesMovies
        }
    }

    override suspend fun fetchPopularMovies(): List<Movie> {

        val fetchMoviesPopular = movieRemoteDataSource.fetchMoviesPopular()
        movieMapper.transform(fetchMoviesPopular)
    }
}
