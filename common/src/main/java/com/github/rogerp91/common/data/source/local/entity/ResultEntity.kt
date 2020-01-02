package com.github.rogerp91.common.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.rogerp91.common.util.test.ResultEntityTest

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
) {
    companion object {
        val EMPTY = ResultEntityTest.getResultEntityEmpty()
    }
}
