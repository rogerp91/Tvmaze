package com.github.rogerp91.common.mapper.stub

import com.github.rogerp91.common.mapper.Mapper
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class MapperImp {

    private lateinit var mapper: Mapper<StubDto, StubEntity, StubObject>

    @Before
    fun setUp() {
        mapper = MapperStubMapper()
    }

    @Test
    fun `dtos to domains`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val list: List<StubObject> = mapper.dtosToDomains(listOf(StubDto("1"), StubDto("2")))

        assertEquals(2, list.size)
    }

    @Test
    fun `dto to domain`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val stubObject: StubObject = mapper.dtoToDomain(StubDto("2"))

        assertEquals("2", stubObject.id)
    }

    @Test
    fun `entities to domains`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val list: List<StubObject> =
            mapper.entitiesToDomains(listOf(StubEntity("1"), StubEntity("2")))

        assertEquals(2, list.size)
    }

    @Test
    fun `entity to domain`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val stubObject: StubObject = mapper.entityToDomain(StubEntity("5"))

        assertEquals("5", stubObject.id)
    }

    @Test
    fun `entity to dto`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val dto: StubDto = mapper.entityToDto(StubEntity("5"))

        assertEquals("5", dto.id)
    }

    @Test
    fun `dto to entity`() {
        val mapper: Mapper<StubDto, StubEntity, StubObject> = MapperStubMapper()
        val entity: StubEntity = mapper.dtoToEntity(StubDto("52"))

        assertEquals("52", entity.id)
    }
}

internal data class StubDto(val id: String)
internal data class StubEntity(val id: String)
internal class StubObject(val id: String)
