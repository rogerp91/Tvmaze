package com.github.rogerp91.common.mapper.stub

import com.github.rogerp91.common.mapper.Mapper

internal class MapperStubMapper : Mapper<StubDto, StubEntity, StubObject> {

    override fun dtosToDomains(dtos: List<StubDto>): List<StubObject> = dtos.map { dtoToDomain(it) }

    override fun dtoToDomain(dto: StubDto): StubObject = StubObject(dto.id)

    override fun entitiesToDomains(entities: List<StubEntity>): List<StubObject> =
        entities.map { entityToDomain(it) }

    override fun entityToDomain(entity: StubEntity): StubObject = StubObject(entity.id)

    override fun dtoToEntity(dto: StubDto): StubEntity = StubEntity(dto.id)

    override fun entityToDto(entity: StubEntity): StubDto = StubDto(entity.id)
}