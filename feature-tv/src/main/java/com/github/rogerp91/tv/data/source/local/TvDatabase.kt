package com.github.rogerp91.tv.data.source.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.rogerp91.common.data.source.local.entity.ResultEntity

@Database(entities = [ResultEntity::class], version = 1, exportSchema = false)
abstract class TvDatabase : RoomDatabase() {

    abstract fun tvDao(): TvDao

    companion object {

        @Volatile
        private var INSTANCE: TvDatabase? = null

        fun getInstance(context: Context): TvDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(
                        context
                    ).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            TvDatabase::class.java,
            "Tv.db"
        ).allowMainThreadQueries().build()
    }
}
