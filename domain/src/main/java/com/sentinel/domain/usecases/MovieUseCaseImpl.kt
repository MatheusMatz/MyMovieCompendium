package com.sentinel.domain.usecases

import android.util.Log
import com.sentinel.data.repository.MovieRepository
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.domain.mappers.MovieMapper
import javax.inject.Inject

class MovieUseCaseImpl @Inject constructor (
    private val movieRepository: MovieRepository,
    private val movieMapper: MovieMapper
) : MovieUseCase {

    override suspend fun loadTrendiesMovies(): List<MovieDTO> {

        val response = movieRepository.fetchDayTrendiesMovies()

        Log.d("gustavo", response.toString())
        return movieMapper.transform(response?.results)
    }
}