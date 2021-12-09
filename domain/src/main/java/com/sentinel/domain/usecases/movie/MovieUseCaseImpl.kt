package com.sentinel.domain.usecases.movie

import com.sentinel.data.repository.movie.IMovieRepository
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.domain.mappers.MovieMapper
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor(
    private val movieRepository: IMovieRepository,
    private val movieMapper: MovieMapper
) : IMovieUseCase {

    override suspend fun loadTrendiesMovies(): List<MovieDTO> {
        val response = movieRepository.fetchDayTrendiesMovies()
        return movieMapper.transform(response).sortedBy {
            it.vote_average
        }
    }

    override suspend fun loadPopularMovies(): List<MovieDTO> {
        val response = movieRepository.fetchPopularMovies()
        return movieMapper.transform(response)
    }
}
