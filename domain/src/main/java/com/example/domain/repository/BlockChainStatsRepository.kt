package com.example.domain.repository

import com.example.domain.model.StatsDomainModel
import com.example.shared.network.NetworkResult

interface BlockChainStatsRepository {
    suspend fun fetchStats(): NetworkResult<StatsDomainModel>
}