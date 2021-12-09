package com.sentinel.data.repository.genre

import com.sentinel.data.datasource.local.dao.GenreDao
import com.sentinel.data.datasource.remote.datasources.GenreRemoteDataSource
import com.sentinel.data.mappers.GenreEntityMapper
import com.sentinel.data.mappers.GenreMapper
import com.sentinel.data.models.Genre
import javax.inject.Inject

class GenreRepositoryImpl @Inject constructor(
    private val genreRemoteDataSource: GenreRemoteDataSource,
    private val genreDao: GenreDao,
    private val genreEntityMapper: GenreEntityMapper,
    private val genreMapper: GenreMapper
) : IGenreRepository {

    override suspend fun fetchMovieGenre(): List<Genre> {
        val genres = genreDao.getGenres()

        return if(genres.isNotEmpty()) {
            return genreMapper.transform(genres)
        } else {

            val movieGenre = genreRemoteDataSource.fetchMovieGenre()

            val genreMapped = genreEntityMapper.transform(movieGenre.data?.genres)
            genreDao.insertGenre(genreMapped)

            val genresSaved = genreDao.getGenres()
            val genreTransformed = genreMapper.transform(genresSaved)
            genreTransformed
        }
    }

    override suspend fun fetchTVShowsGenre(): List<Genre> {
        val genres = genreDao.getGenres()

        return if(genres.isNotEmpty()) {
            return genreMapper.transform(genres)
        } else {

            val tvGenre = genreRemoteDataSource.fetchTVGenre()

            val genreMapped = genreEntityMapper.transform(tvGenre.data?.genres)
            genreDao.insertGenre(genreMapped)

            val genresSaved = genreDao.getGenres()
            val genreTransformed = genreMapper.transform(genresSaved)
            genreTransformed
        }
    }
}