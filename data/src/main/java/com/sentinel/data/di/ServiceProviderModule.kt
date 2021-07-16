package com.sentinel.data.di

import com.sentinel.data.datasource.remote.service.GenreService
import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.datasource.remote.service.TrendyService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ServiceProviderModule {

    @Provides
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Provides
    fun provideTrendyService(retrofit: Retrofit): TrendyService =
        retrofit.create(TrendyService::class.java)

    @Provides
    fun provideGenreService(retrofit: Retrofit): GenreService =
        retrofit.create(GenreService::class.java)

}