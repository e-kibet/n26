package com.n26.database.repositories

import com.n26.database.BlockChainDatabase
import com.n26.database.mappers.toDomain
import com.n26.domain.dbrepository.StatsRepository
import com.n26.domain.model.StatsDomainModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

internal class StatsRepositoryImpl(private val database: BlockChainDatabase) : StatsRepository{
    //TODO maybe use some generic result type like in network to have states such as loading etc
    override fun getStats(): Flow<List<StatsDomainModel>> {
        return database.statisticsDao().getStatistics().map {
            it.map { statsEntity ->
               statsEntity.toDomain()
            }
        }
    }
}