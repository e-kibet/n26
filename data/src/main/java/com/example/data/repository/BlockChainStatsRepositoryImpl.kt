package com.example.data.repository

import com.example.data.api.BlockChainAPI
import com.example.data.mappers.toDomain
import com.example.shared.network.NetworkResult
import com.example.domain.model.StatsDomainModel
import com.example.domain.repository.BlockChainStatsRepository
import timber.log.Timber
import java.io.IOException

class BlockChainStatsRepositoryImpl(private val blockChainAPI: BlockChainAPI): BlockChainStatsRepository {
    override suspend fun fetchStats() : NetworkResult<StatsDomainModel> =
        try {
            val blockChainStats = blockChainAPI.fetchStats()
            when {
                blockChainStats.isSuccessful -> NetworkResult.Success(blockChainStats.body()!!.toDomain())
                else -> NetworkResult.APIError
            }

        } catch (e: IOException) {
            Timber.e(e)
            NetworkResult.NetworkError
        } catch (e: Exception) {
            Timber.e(e)
            NetworkResult.ServerError()
        }
}