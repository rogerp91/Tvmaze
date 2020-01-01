package com.github.rogerp91.feature_tv.data.source.repository

import com.github.rogerp91.common.datasource.DataSource
import com.github.rogerp91.common.mapper.Mapper
import com.github.rogerp91.common.repository.Repository
import com.github.rogerp91.feature_tv.data.source.local.entity.ResultEntity
import com.github.rogerp91.feature_tv.data.source.remote.dto.ResultDto
import com.github.rogerp91.feature_tv.domain.model.Result
import io.reactivex.Flowable
import io.reactivex.Single

class TvRepository(
    private val local: DataSource<ResultEntity>,
    private val remote: DataSource<ResultDto>,
    private val mapper: Mapper<ResultDto, ResultEntity, Result>
) : Repository<Result> {

    override fun get(): Flowable<List<Result>> =
        Flowable.concat(getTvLocate(), getTvRemote()).firstOrError().toFlowable()

    override fun get(id: String): Single<Result> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(model: Result) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getTvRemote(): Flowable<List<Result>> = remote.get()
        .flatMap { dtos ->
            Flowable.fromIterable(dtos).doOnNext {
                local.save(mapper.dtoToEntity(it))
            }.toList().toFlowable().map { mapper.dtosToDomains(it) }
        }

    private fun getTvLocate(): Flowable<List<Result>> =
        local.get().map { mapper.entitiesToDomains(it) }
}