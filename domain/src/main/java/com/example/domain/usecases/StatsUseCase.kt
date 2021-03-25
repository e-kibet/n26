package com.example.domain.usecases

import com.example.domain.model.StatsDomainModel
import com.example.domain.repository.BlockchainStatsRepository

typealias StatsBaseUseCase = BaseUseCase<StatsDomainModel,Unit>

class StatsUseCase(private val statsRepository: BlockchainStatsRepository) : StatsBaseUseCase {
    override suspend fun invoke(params: StatsDomainModel) {
        statsRepository.fetchStats()
    }
}