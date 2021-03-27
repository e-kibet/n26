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
package com.n26.network.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.shared.network.NetworkResult
import com.n26.domain.dbrepository.StatsRepository
import com.n26.domain.netrepository.BlockChainStatsRepository
import org.koin.java.KoinJavaComponent.inject

class StatsWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {

    val statsRepository: StatsRepository by inject(StatsRepository::class.java)
    val blockChainStatsRepository: BlockChainStatsRepository by inject(BlockChainStatsRepository::class.java)
    override suspend fun doWork(): Result {
        return when (val fetchStats = blockChainStatsRepository.fetchStats()) {
            is NetworkResult.Success -> {
                statsRepository.saveStats(fetchStats.data)
                Result.success()
            }
            NetworkResult.APIError -> Result.failure()
            NetworkResult.NetworkError -> Result.failure()
            is NetworkResult.ServerError -> Result.failure()
        }
    }
}