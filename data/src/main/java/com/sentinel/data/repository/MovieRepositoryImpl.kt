package com.sentinel.data.repository

import android.util.Log
import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.local.entities.MovieEntity
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

    override suspend fun fetchDayTrendiesMovies(): List<Movie> {

        val movies = movieDao.getTrendiesMovies(true)

        return if (!movies.isNullOrEmpty()) {
            val movieMapped = movieMapper.transform(movies)
            movieMapped
        } else {

            val fetchTrendiesMovies = movieRemoteDataSource.fetchTrendiesMovies()

            movieEntityMapper.checkIsTrendy(true)

            val movieMapped = movieEntityMapper.transform(fetchTrendiesMovies.data?.results)

            movieDao.insertTrendyMovies(movieMapped)

            val moviesSaved = movieDao.getTrendiesMovies(true)
            val moviesTransformed = movieMapper.transform(moviesSaved)
            moviesTransformed
        }
    }

    override suspend fun fetchPopularMovies(): List<Movie> {

        val movies = movieDao.getMovies()

        return if (!movies.isNullOrEmpty() && movies.any { !it.isTrendy }) {
            val movieMapped = movieMapper.transform(movies)
            movieMapped
        } else {

            val fetchMoviesPopular = movieRemoteDataSource.fetchMoviesPopular()
            val movieMapped = movieEntityMapper.transform(fetchMoviesPopular.data?.results)

            movieDao.insertMovies(movieMapped)

            val moviesSaved = movieDao.getMovies()
            val moviesTransformed = movieMapper.transform(moviesSaved)
            moviesTransformed
        }
    }
}
