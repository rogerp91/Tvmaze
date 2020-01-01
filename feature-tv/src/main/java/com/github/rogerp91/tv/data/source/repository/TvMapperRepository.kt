package com.github.rogerp91.tv.data.source.repository

import com.github.rogerp91.common.mapper.Mapper
import com.github.rogerp91.tv.data.source.local.entity.ResultEntity
import com.github.rogerp91.tv.data.source.remote.dto.ResultDto
import com.github.rogerp91.tv.domain.model.Result

open class TvMapperRepository(
    private val mapperObject: TvMapperObject
) : Mapper<ResultDto, ResultEntity, Result> {

    override fun dtosToDomains(dtos: List<ResultDto>): List<Result> = dtos.map { dtoToDomain(it) }

    override fun dtoToDomain(dto: ResultDto): Result = mapperObject.getNewResultFromDto(dto)

    override fun entitiesToDomains(entities: List<ResultEntity>): List<Result> =
        entities.map { entityToDomain(it) }

    override fun entityToDomain(entity: ResultEntity): Result =
        mapperObject.getNewResultFromEntity(entity)

    override fun dtoToEntity(dto: ResultDto): ResultEntity = mapperObject.getNewEntityFromDto(dto)

    override fun entityToDto(entity: ResultEntity): ResultDto =
        mapperObject.getNewDtoFromEntity(entity)
}
