package com.github.rogerp91.feature_tv.data.source.repository

import com.github.rogerp91.common.mapper.Mapper
import com.github.rogerp91.feature_tv.data.source.local.TvLocalDataSource
import com.github.rogerp91.feature_tv.data.source.local.entity.ResultEntity
import com.github.rogerp91.feature_tv.data.source.remote.TvRemoteDataSource
import com.github.rogerp91.feature_tv.data.source.remote.dto.ResultDto
import com.github.rogerp91.feature_tv.domain.model.Result
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Flowable
import org.junit.Before

class TvRepositoryTest {

    private lateinit var mapper: Mapper<ResultDto, ResultEntity, Result>
    private lateinit var repository: TvRepository
    @Before
    fun setUp() {
        mapper = TvMapperRepository(TvMapperObject())
    }


    private fun getMockTvLocalDataSource(list: List<ResultEntity>): TvLocalDataSource {
        return mock {
            on { get() } doReturn Flowable.just(list)
        }
    }

    private fun getMockRemoteDataSource(list: List<ResultDto>): TvRemoteDataSource {
        return mock {
            on { get() } doReturn Flowable.just(list)
        }
    }
}