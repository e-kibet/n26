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
package com.n26.network.repository

import com.n26.domain.model.StatsDomainModel
import com.n26.domain.netrepository.BlockChainStatsRepository
import com.n26.network.api.BlockChainAPI
import com.n26.network.mappers.toDomain
import com.n26.shared.network.NetworkResult
import timber.log.Timber
import java.io.IOException

class BlockChainStatsRepositoryImpl(
    private val blockChainAPI: BlockChainAPI
) : BlockChainStatsRepository {

    override suspend fun fetchStats(): NetworkResult<StatsDomainModel> =
        try {
            val blockChainStats = blockChainAPI.fetchStats()
            when {
                blockChainStats.isSuccessful -> NetworkResult.Success(
                    blockChainStats.body()!!.toDomain()
                )
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