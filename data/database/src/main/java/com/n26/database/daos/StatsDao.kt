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
package com.n26.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.n26.database.entities.StatsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface StatsDao : BaseDao<StatsEntity> {

    @Query("SELECT * FROM stats ORDER BY timestamp DESC")
    fun getStatistics(): Flow<List<StatsEntity>>
}