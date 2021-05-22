package com.sentinel.data.entities

data class MovieResponse(
    val page: Int,
    val results: List<Movie>
)