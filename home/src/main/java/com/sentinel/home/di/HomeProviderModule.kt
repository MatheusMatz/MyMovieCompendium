package com.sentinel.home.di

import com.sentinel.home.domain.GenreVOMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class HomeProviderModule {

    @Provides
    fun providesGenreVoMapper() = GenreVOMapper()
}