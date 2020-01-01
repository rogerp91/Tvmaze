package com.github.rogerp91.feature_tv.data.source.remote

import com.github.rogerp91.common.datasource.DataSource
import com.github.rogerp91.feature_tv.data.source.remote.dto.ResultDto
import io.reactivex.Flowable

open class TvRemoteDataSource : DataSource<ResultDto> {

    override fun get(): Flowable<List<ResultDto>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: String): Flowable<ResultDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(model: ResultDto) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}