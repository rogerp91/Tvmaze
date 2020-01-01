package com.github.rogerp91.feature_tv.data.source.local

import com.github.rogerp91.common.datasource.DataSource
import com.github.rogerp91.feature_tv.data.source.local.entity.ResultEntity
import io.reactivex.Flowable

open class TvLocalDataSource(
    private val dao: TvDao
) : DataSource<ResultEntity> {

    override fun get(): Flowable<List<ResultEntity>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: String): Flowable<ResultEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun save(model: ResultEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun refresh() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}