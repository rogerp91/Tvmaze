package com.github.rogerp91.feature_tv.data.source.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.rogerp91.tv.data.source.local.TvDao
import com.github.rogerp91.tv.data.source.local.TvDatabase
import com.github.rogerp91.common.data.source.local.entity.ResultEntity
import com.github.rogerp91.common.util.test.ResultEntityTest
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class TvDaoTest {

    private lateinit var database: TvDatabase
    private lateinit var tvDao: TvDao

    @Before
    fun setUp() {
        database = Room.inMemoryDatabaseBuilder(getApplicationContext(), TvDatabase::class.java)
            .allowMainThreadQueries().build()
        tvDao = database.tvDao()
    }

    @After
    fun after() {
        database.close()
    }

    @Test
    fun insertTv_entityResult_InTheDatabase() {
        val entity = getStubResultEntity()
        val result = tvDao.insertTv(entity)
        assertNotNull(result)
        assertEquals(419704.toLong(), result)
    }

    @Test
    fun getTv_insertMultiplesEntityResult_InTheDatabase_returnEntityResult() {
        val entity = getStubResultEntity()
        val entity2 = getStubResultEntity2()
        tvDao.insertTv(entity)
        tvDao.insertTv(entity2)

        val result = tvDao.getTv(419707)

        assertNotNull(result)
        assertEquals(419707.toLong(), result!!.id.toLong())
    }

    @Test
    fun getTv_insertMultiplesEntityResult_InTheDatabase_returnListEntityResult() {
        val entity = getStubResultEntity()
        val entity2 = getStubResultEntity2()
        tvDao.insertTv(entity)
        tvDao.insertTv(entity2)

        val result = tvDao.getTv()

        assertNotNull(result)
        assertEquals(2, result.size)
    }

    private fun getStubResultEntity(): ResultEntity {
        return ResultEntityTest.getStubResultEntity()
    }

    private fun getStubResultEntity2(): ResultEntity {
        return ResultEntityTest.getStubResultEntity2()
    }
}
