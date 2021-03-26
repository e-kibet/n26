package com.n26.domain.dbrepository

import com.n26.domain.model.StatsDomainModel
import kotlinx.coroutines.flow.Flow

interface StatsRepository {

    //TODO Maybe return a page. I dont know just a thought
    fun getStats(): Flow<List<StatsDomainModel>>
}