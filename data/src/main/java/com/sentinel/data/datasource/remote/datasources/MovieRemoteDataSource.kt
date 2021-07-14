package com.sentinel.data.datasource.remote.datasources

import com.sentinel.data.datasource.remote.BaseDataSource
import com.sentinel.data.datasource.remote.service.TrendyService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val trendyService: TrendyService) :
    BaseDataSource() {

    suspend fun fetchTrendiesMovies() = getResult { trendyService.getDayTrendiesMovies() }
}
