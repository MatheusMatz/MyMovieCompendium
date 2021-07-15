package com.sentinel.data.models

data class Review(
    val author: String,
    val author_details: Author,
    val content: String,
    val created_at: String,
    val url: String
)
