package com.github.rogerp91.tv.domain.model

class Result(
    private val popularity: Double,
    private val voteCount: Int,
    private val video: Boolean,
    private val posterPath: String,
    private val id: Int,
    private val adult: Boolean,
    private val backdropPath: String,
    private val originalLanguage: String,
    private val originalTitle: String,
    private val title: String,
    private val voteAverage: Double,
    private val overview: String,
    private val releaseDate: String
)
