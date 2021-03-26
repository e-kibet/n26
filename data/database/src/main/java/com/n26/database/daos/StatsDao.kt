package com.n26.database.daos

import androidx.room.Dao
import androidx.room.Query
import com.n26.database.entities.StatsEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface StatsDao : BaseDao<StatsEntity> {

    @Query("select * from stats order by timestamp desc")
    fun getStatistics(): Flow<List<StatsEntity>>
}