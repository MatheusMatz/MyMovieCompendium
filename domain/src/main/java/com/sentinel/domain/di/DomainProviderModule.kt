package com.sentinel.domain.di

import com.sentinel.domain.mappers.GenreMapper
import com.sentinel.domain.mappers.MovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainProviderModule {

    @Provides
    fun provideMovieMapper() = MovieMapper()

    @Provides
    fun providesGenreMapper() = GenreMapper()
}
