package com.sentinel.domain.di

import com.sentinel.domain.usecases.genre.GenreUseCaseImpl
import com.sentinel.domain.usecases.genre.IGenreUseCase
import com.sentinel.domain.usecases.movie.IMovieUseCase
import com.sentinel.domain.usecases.movie.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindingsModule {

    @Binds
    fun bindingMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): IMovieUseCase

    @Binds
    fun bindingGenreUseCase(genreUseCaseImpl: GenreUseCaseImpl): IGenreUseCase
}
