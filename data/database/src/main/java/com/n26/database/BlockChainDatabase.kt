package com.n26.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.n26.database.daos.StatsDao
import com.n26.database.entities.StatsEntity
import org.koin.android.BuildConfig

@Database(entities = [StatsEntity::class], version = 0)
internal abstract class BlockChainDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE: BlockChainDatabase? = null

        fun getInstance(context: Context): BlockChainDatabase {
            if (INSTANCE != null) {
                return INSTANCE!!
            }

            val builder =
                Room.databaseBuilder(context, BlockChainDatabase::class.java, "blockchain-db")
            if (BuildConfig.DEBUG) {
               builder .fallbackToDestructiveMigration()
            }
            return builder.build()
        }
    }

    abstract fun statisticsDao(): StatsDao
}