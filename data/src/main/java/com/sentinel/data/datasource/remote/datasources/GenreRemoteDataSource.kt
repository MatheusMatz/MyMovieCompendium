package com.sentinel.data.datasource.remote.datasources

import com.sentinel.data.datasource.remote.BaseDataSource
import com.sentinel.data.datasource.remote.service.GenreService
import javax.inject.Inject

class GenreRemoteDataSource @Inject constructor(
    private val genreService: GenreService
) : BaseDataSource() {

    suspend fun fetchMovieGenre() =
        getResult { genreService.getMovieGenres() }

    suspend fun fetchTVGenre() =
        getResult { genreService.getTVGenres() }
}