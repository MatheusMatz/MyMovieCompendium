package com.sentinel.data.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sentinel.data.datasource.local.MovieCompendiumDatabase
import com.sentinel.data.datasource.local.dao.MovieDao
import com.sentinel.data.datasource.remote.service.MovieService
import com.sentinel.data.repository.MovieRepository
import com.sentinel.data.repository.MovieRepositoryImpl
import dagger.Binds
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
    fun provideMovieService(retrofit: Retrofit): MovieService =
        retrofit.create(MovieService::class.java)

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): MovieCompendiumDatabase =
        MovieCompendiumDatabase.getDatabase(appContext)

    @Provides
    @Singleton
    fun provideMovieDao(db: MovieCompendiumDatabase): MovieDao = db.movieDao()

    private const val BASE_URL = "https://api.themoviedb.org/3/"
}
