package com.github.rogerp91.common.data.source.remote.dto

data class ResultDto(
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    val id: Int,
    val adult: Boolean,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)
