package com.sentinel.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.forfun.category.domain.GenreVO
import com.sentinel.domain.dtos.MovieDTO
import com.sentinel.domain.usecases.genre.GenreUseCaseImpl
import com.sentinel.domain.usecases.genre.IGenreUseCase
import com.sentinel.domain.usecases.movie.IMovieUseCase
import com.sentinel.home.domain.GenreVOMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieUseCase: IMovieUseCase,
    private val genreUseCase: IGenreUseCase,
    private val genreVOMapper: GenreVOMapper
) : ViewModel() {

    private var _trendiesMovies = MutableLiveData<List<MovieDTO>>()
    val trendiesMovies: LiveData<List<MovieDTO>> get() = _trendiesMovies

    private var _popularMovies = MutableLiveData<List<MovieDTO>>()
    val popularMoviesMovies: LiveData<List<MovieDTO>> get() = _trendiesMovies

    private var _genreMovieLV = MutableLiveData<List<GenreVO>>()
    val genreMovieLiveData: LiveData<List<GenreVO>> get() = _genreMovieLV

    fun loadHome() = viewModelScope.launch {

        val trendiesMovies = movieUseCase.loadTrendiesMovies()
        val movies = movieUseCase.loadPopularMovies()
        val genres = genreUseCase.fetchMoviesCategories()

        _trendiesMovies.value = trendiesMovies
        _popularMovies.value = movies
        _genreMovieLV.value = genreVOMapper.transform(genres)
    }
}
