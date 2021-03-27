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
package com.n26.database.repositories

import com.n26.database.daos.StatsDao
import com.n26.database.mappers.toDomain
import com.n26.database.mappers.toEntityStats
import com.n26.domain.dbrepository.StatsRepository
import com.n26.domain.model.StatsDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StatsRepositoryImpl(
    private val statsDao: StatsDao
) : StatsRepository {

    // TODO maybe use some generic result type like in network to have states such as loading etc
    override fun getStats(): Flow<List<StatsDomainModel>> {
        return statsDao.getStatistics().map {
            it.map { statsEntity ->
                statsEntity.toDomain()
            }
        }
    }

    override suspend fun saveStats(data: StatsDomainModel) {
        statsDao.save(data.toEntityStats())
    }
}