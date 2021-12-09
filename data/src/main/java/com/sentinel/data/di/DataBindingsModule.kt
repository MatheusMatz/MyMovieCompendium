package com.sentinel.data.di

import com.sentinel.data.repository.genre.GenreRepositoryImpl
import com.sentinel.data.repository.genre.IGenreRepository
import com.sentinel.data.repository.movie.IMovieRepository
import com.sentinel.data.repository.movie.MovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataBindingsModule {

    @Binds
    fun bindMovieRepository(movieRepositoryImpl: MovieRepositoryImpl): IMovieRepository

    @Binds
    fun bindGenreRepository(genreRepositoryImpl: GenreRepositoryImpl): IGenreRepository
}
