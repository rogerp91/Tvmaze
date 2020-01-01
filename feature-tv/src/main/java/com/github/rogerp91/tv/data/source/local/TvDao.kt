package com.github.rogerp91.tv.data.source.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.rogerp91.tv.data.source.local.entity.ResultEntity

@Dao
interface TvDao {

    @Query("SELECT * FROM Result")
    fun getTv(): List<ResultEntity>

    @Query("SELECT * FROM Result WHERE id = :id")
    fun getTv(id: Long): ResultEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTv(entity: ResultEntity): Long?
}
