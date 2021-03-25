package com.example.domain.usecases

import com.example.domain.model.StatsDomainModel
import com.example.domain.repository.BlockChainStatsRepository

typealias StatsBaseUseCase = BaseUseCase<StatsDomainModel,Unit>

class StatsUseCase(private val statsRepository: BlockChainStatsRepository) : StatsBaseUseCase {
    override suspend fun invoke(params: StatsDomainModel) {
        statsRepository.fetchStats()
    }
}