package com.sentinel.domain.di

import com.sentinel.domain.usecases.MovieUseCase
import com.sentinel.domain.usecases.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DomainBindingsModule {

    @Binds
    fun bindingMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}
