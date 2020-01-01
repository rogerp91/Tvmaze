package com.github.rogerp91.tv.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result")
data class ResultEntity(
    val popularity: Double,
    val voteCount: Int,
    val video: Boolean,
    val posterPath: String,
    @PrimaryKey
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
