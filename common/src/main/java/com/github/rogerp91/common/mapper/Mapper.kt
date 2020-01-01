package com.github.rogerp91.common.mapper

/**
 * Mapper
 * @param D DTO
 * @param E Entity DataBase
 * @param B BO
 */
interface Mapper<D, E, B> {

    fun dtosToDomains(dtos: List<D>): List<B>

    fun dtoToDomain(dto: D): B

    fun entitiesToDomains(entities: List<E>): List<B>

    fun entityToDomain(entity: E): B

    fun dtoToEntity(dto: D): E

    fun entityToDto(entity: E): D
}
