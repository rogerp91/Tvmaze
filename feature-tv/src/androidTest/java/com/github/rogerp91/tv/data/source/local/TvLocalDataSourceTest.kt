package com.github.rogerp91.tv.data.source.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.rogerp91.common.data.source.local.entity.ResultEntity
import com.github.rogerp91.common.util.test.ResultEntityTest
import io.reactivex.subscribers.TestSubscriber
import junit.framework.TestCase
import org.junit.After
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class TvLocalDataSourceTest {

    private lateinit var database: TvDatabase
    private lateinit var tvDao: TvDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            TvDatabase::class.java
        )
            .allowMainThreadQueries().build()
        tvDao = database.tvDao()
    }

    @After
    fun after() {
        database.close()
    }

    @Test
    fun getLocalDataSource_getListResultEntityOfDao_returnListResultEntity() {
        val entity = getStubResultEntity()
        val entity2 = getStubResultEntity2()
        tvDao.insertTv(entity)
        tvDao.insertTv(entity2)

        val subscriber: TestSubscriber<List<ResultEntity>> = TestSubscriber()

        val localDataSource = TvLocalDataSource(tvDao)
        val result = localDataSource.get()
        result.subscribe(subscriber)

        subscriber.assertComplete()
        subscriber.assertValues(listOf(entity, entity2))
    }

    @Test
    fun getLocalDataSource_getListResultEntityOfDao_returnListEmpty() {
        val subscriber: TestSubscriber<List<ResultEntity>> = TestSubscriber()

        val localDataSource = TvLocalDataSource(tvDao)
        val result = localDataSource.get()
        result.subscribe(subscriber)

        subscriber.assertComplete()
        assertTrue(subscriber.values()[0].isEmpty())
    }

    @Test
    fun getForIdLocalDataSource_getListResultEntityOfDao_returnResultEntity() {
        val entity = getStubResultEntity()
        val entity2 = getStubResultEntity2()
        tvDao.insertTv(entity)
        tvDao.insertTv(entity2)

        val subscriber: TestSubscriber<ResultEntity> = TestSubscriber()

        val localDataSource = TvLocalDataSource(tvDao)
        val result = localDataSource.get("419704")
        result.subscribe(subscriber)

        subscriber.assertComplete()
        subscriber.assertValue(entity)
    }

    @Test
    fun getForIdLocalDataSource_getListResultEntityOfDao_returnEmpty() {
        val subscriber: TestSubscriber<ResultEntity> = TestSubscriber()

        val localDataSource = TvLocalDataSource(tvDao)
        val result = localDataSource.get("412704")
        result.subscribe(subscriber)

        subscriber.assertComplete()
        assertNotNull(subscriber.values())
    }

    @Test
    fun saveLocalDataSource_insertTvResultEntity_returnLong() {
        val localDataSource = TvLocalDataSource(tvDao)
        val id1 = localDataSource.save(getStubResultEntity())
        val id2 = localDataSource.save(getStubResultEntity2())

        TestCase.assertEquals(419704.toLong(), id1)
        TestCase.assertEquals(419707.toLong(), id2)
    }

    private fun getStubResultEntity(): ResultEntity {
        return ResultEntityTest.getStubResultEntity()
    }

    private fun getStubResultEntity2(): ResultEntity {
        return ResultEntityTest.getStubResultEntity2()
    }

}