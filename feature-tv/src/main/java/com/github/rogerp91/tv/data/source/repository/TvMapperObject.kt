package com.github.rogerp91.tv.data.source.repository

import com.github.rogerp91.tv.data.source.local.entity.ResultEntity
import com.github.rogerp91.tv.data.source.remote.dto.ResultDto
import com.github.rogerp91.tv.domain.model.Result

class TvMapperObject {

    fun getNewResultFromDto(dto: ResultDto): Result {
        return Result(
            dto.popularity,
            dto.voteCount,
            dto.video,
            dto.posterPath,
            dto.id,
            dto.adult,
            dto.backdropPath,
            dto.originalLanguage,
            dto.originalTitle,
            dto.title,
            dto.voteAverage,
            dto.overview,
            dto.releaseDate
        )
    }

    fun getNewEntityFromDto(dto: ResultDto): ResultEntity {
        return ResultEntity(
            dto.popularity,
            dto.voteCount,
            dto.video,
            dto.posterPath,
            dto.id,
            dto.adult,
            dto.backdropPath,
            dto.originalLanguage,
            dto.originalTitle,
            dto.title,
            dto.voteAverage,
            dto.overview,
            dto.releaseDate
        )
    }

    fun getNewDtoFromEntity(entity: ResultEntity): ResultDto {
        return ResultDto(
            entity.popularity,
            entity.voteCount,
            entity.video,
            entity.posterPath,
            entity.id,
            entity.adult,
            entity.backdropPath,
            entity.originalLanguage,
            entity.originalTitle,
            entity.title,
            entity.voteAverage,
            entity.overview,
            entity.releaseDate
        )
    }

    fun getNewResultFromEntity(entity: ResultEntity): Result {
        return Result(
            entity.popularity,
            entity.voteCount,
            entity.video,
            entity.posterPath,
            entity.id,
            entity.adult,
            entity.backdropPath,
            entity.originalLanguage,
            entity.originalTitle,
            entity.title,
            entity.voteAverage,
            entity.overview,
            entity.releaseDate
        )
    }
}
