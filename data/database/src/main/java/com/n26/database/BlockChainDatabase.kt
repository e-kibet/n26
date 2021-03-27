/*
 * Copyright 2021 N26
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.n26.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.n26.database.daos.StatsDao
import com.n26.database.entities.StatsEntity
import org.koin.android.BuildConfig

@Database(entities = [StatsEntity::class], version = 1)
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
                builder.fallbackToDestructiveMigration()
            }
            return builder.build()
        }
    }

    abstract fun statisticsDao(): StatsDao
}