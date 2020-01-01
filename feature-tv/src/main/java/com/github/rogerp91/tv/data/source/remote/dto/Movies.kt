package com.github.rogerp91.tv.data.source.remote.dto

data class Movies(
    private val page: Int,
    private val totalResults: Int,
    private val totalPages: Int,
    private val results: List<ResultDto>
)
