package com.sentinel.domain.dtos

data class MovieDTO(
    val title: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    val vote_count: Int?,
    val overview: String?,
    val release_date: String?,
    val vote_average: Float?,
    val id: Int?,
    val adult: Boolean?
)