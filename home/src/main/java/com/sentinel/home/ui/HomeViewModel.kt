package com.sentinel.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.domain.usecases.genre.GenreUseCaseImpl
import com.sentinel.domain.usecases.genre.IGenreUseCase
import com.sentinel.domain.usecases.movie.IMovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCase: IMovieUseCase,
    private val genreUseCase: IGenreUseCase
) : ViewModel() {

    private var _trendiesMovies = MutableLiveData<List<MovieDTO>>()
    val trendiesMovies: LiveData<List<MovieDTO>> get() = _trendiesMovies

    private var _popularMovies = MutableLiveData<List<MovieDTO>>()
    val popularMoviesMovies: LiveData<List<MovieDTO>> get() = _trendiesMovies

    fun loadHome() = viewModelScope.launch {

        val genres = genreUseCase.fetchMoviesCategories()

    }
}
