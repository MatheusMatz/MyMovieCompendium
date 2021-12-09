package com.sentinel.data.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sentinel.data.datasource.local.MovieCompendiumDatabase
import com.sentinel.data.datasource.local.dao.GenreDao
import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.remote.datasources.GenreRemoteDataSource
import com.sentinel.data.datasource.remote.datasources.MovieRemoteDataSource
import com.sentinel.data.datasource.remote.service.GenreService
import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.datasource.remote.service.TrendyService
import com.sentinel.data.mappers.GenreEntityMapper
import com.sentinel.data.mappers.GenreMapper
import com.sentinel.data.mappers.MovieEntityMapper
import com.sentinel.data.mappers.MovieMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataProviderModule {

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    @Provides
    fun provideMovieRemoteDataSource(
        movieService: MovieService,
        trendyService: TrendyService
    ): MovieRemoteDataSource =
        MovieRemoteDataSource(movieService, trendyService)

    @Provides
    fun providesGenreRemoteDataSource(genreService: GenreService): GenreRemoteDataSource =
        GenreRemoteDataSource(genreService)

    @Provides
    fun provideMovieEntityMapper(): MovieEntityMapper = MovieEntityMapper()

    @Provides
    fun provideMovieMapper(): MovieMapper = MovieMapper()

    @Provides
    fun providesGenreEntityMapper(): GenreEntityMapper = GenreEntityMapper()

    @Provides
    fun providesGenreMapper(): GenreMapper = GenreMapper()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MovieCompendiumDatabase =
        MovieCompendiumDatabase.getDatabase(appContext)

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieCompendiumDatabase): MovieDao = db.movieDao()

    @Provides
    @Singleton
    fun provideGenreDao(db: MovieCompendiumDatabase): GenreDao = db.genreDao()

    private const val BASE_URL = "https://api.themoviedb.org/3/"
}
