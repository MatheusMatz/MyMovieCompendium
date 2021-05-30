package com.sentinel.data.datasource.remote.responses

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)
