package com.sentinel.domain.usecases.genre

import com.sentinel.data.repository.genre.IGenreRepository
import com.sentinel.domain.dtos.GenreDTO
import com.sentinel.domain.mappers.GenreMapper
import javax.inject.Inject

class GenreUseCaseImpl @Inject constructor(
    private val repository: IGenreRepository,
    private val genreMapper: GenreMapper
): IGenreUseCase {

    override suspend fun fetchMoviesCategories(): List<GenreDTO> {
        val response = repository.fetchMovieGenre()
        return genreMapper.transform(response)
    }

    override suspend fun fetchTVCategories(): List<GenreDTO> {
        TODO("Not yet implemented")
    }
}