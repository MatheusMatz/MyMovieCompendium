package com.sentinel.data.models

data class Movie(
    val id: Int,
    val title: String,
    val original_language: String,
    val original_title: String,
    val poster_path: String,
    val vote_count: Int,
    val overview: String,
    val release_date: String,
    val vote_average: Float,
    val video: Boolean,
    val adult: Boolean,
    val backdrop_path: String,
    val popularity: Double,
    val isTrendy: Boolean
)
