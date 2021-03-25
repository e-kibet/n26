package com.example.domain.repository

interface BlockchainStatsRepository {
    suspend fun fetchStats()
}