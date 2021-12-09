package com.sentinel.data.repository.genre

import com.sentinel.data.models.Genre

interface IGenreRepository {
    suspend fun fetchMovieGenre() : List<Genre>
    suspend fun fetchTVShowsGenre() : List<Genre>
}