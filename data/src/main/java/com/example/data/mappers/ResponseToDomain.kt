package com.example.data.mappers

import com.example.data.models.StatsResponse
import com.example.domain.model.StatsDomainModel

fun StatsResponse.toDomain() = StatsDomainModel(
    marketPrice = marketPriceUsd
)