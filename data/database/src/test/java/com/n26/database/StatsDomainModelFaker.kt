package com.n26.database

import com.n26.domain.model.StatsDomainModel

object StatsDomainModelFaker {
    fun create(
        timeStamp: Long = 0L,
        blocksSize: Int = 0,
        difficulty: Long = 0L,
        estimatedBtcSent: Long = 0L,
        estimatedTransactionVolumeUsd: Double = 0.0,
        hashRate: Double = 0.0,
        marketPrice: Double = 0.0,
        minersRevenueBtc: Int = 0,
        minersRevenueUsd: Double = 0.0,
        minutesBetweenBlocks: Double = 0.0,
        nBlocksMined: Int = 0,
        nBlocksTotal: Int = 0,
        nBtcMined: Long = 0L,
        nTx: Int = 0,
        nextretarget: Int = 0,
        totalBtcSent: Long = 0L,
        totalFeesBtc: Long = 0L,
        totalbc: Long = 0L,
        tradeVolumeBtc: Double = 0.0,
        tradeVolumeUsd: Double = 0.0
    ) = StatsDomainModel(
        timestamp = timeStamp,
        blocksSize = blocksSize,
        difficulty = difficulty,
        estimatedBtcSent = estimatedBtcSent,
        estimatedTransactionVolumeUsd = estimatedTransactionVolumeUsd,
        hashRate = hashRate,
        marketPrice = marketPrice,
        minersRevenueBtc = minersRevenueBtc,
        minersRevenueUsd = minersRevenueUsd,
        minutesBetweenBlocks = minutesBetweenBlocks,
        nBlocksMined = nBlocksMined,
        nBlocksTotal = nBlocksTotal,
        nBtcMined = nBtcMined,
        nTx = nTx,
        nextretarget = nextretarget,
        totalBtcSent = totalBtcSent,
        totalFeesBtc = totalFeesBtc,
        totalbc = totalbc,
        tradeVolumeBtc = tradeVolumeBtc,
        tradeVolumeUsd = tradeVolumeUsd
    )
}