package com.sentinel.domain.usecases.genre

import com.sentinel.domain.dtos.GenreDTO

interface IGenreUseCase {
    suspend fun fetchMoviesCategories() : List<GenreDTO>
    suspend fun fetchTVCategories() : List<GenreDTO>
}