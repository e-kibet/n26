package com.n26.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stats")
internal data class StatsEntity(

    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "timestamp")
    val timestamp: Long,

    @ColumnInfo(name = "blocks_size")
    val blocksSize: Int,

    @ColumnInfo(name = "difficulty")
    val difficulty: Long,

    @ColumnInfo(name = "estimated_btc_sent")
    val estimatedBtcSent: Long,

    @ColumnInfo(name = "estimated_transaction_volume_usd")
    val estimatedTransactionVolumeUsd: Double,

    @ColumnInfo(name = "hash_rate")
    val hashRate: Double,

    @ColumnInfo(name = "market_price_usd")
    val marketPriceUsd: Double,

    @ColumnInfo(name = "miners_revenue_btc")
    val minersRevenueBtc: Int,

    @ColumnInfo(name = "miners_revenue_usd")
    val minersRevenueUsd: Double,

    @ColumnInfo(name = "minutes_between_blocks")
    val minutesBetweenBlocks: Double,

    @ColumnInfo(name = "n_blocks_mined")
    val nBlocksMined: Int,

    @ColumnInfo(name = "n_blocks_total")
    val nBlocksTotal: Int,

    @ColumnInfo(name = "n_btc_mined")
    val nBtcMined: Long,

    @ColumnInfo(name = "n_tx")
    val nTx: Int,

    @ColumnInfo(name = "nextretarget")
    val nextretarget: Int,

    @ColumnInfo(name = "total_btc_sent")
    val totalBtcSent: Long,

    @ColumnInfo(name = "total_fees_btc")
    val totalFeesBtc: Long,

    @ColumnInfo(name = "totalbc")
    val totalbc: Long,

    @ColumnInfo(name = "trade_volume_btc")
    val tradeVolumeBtc: Double,

    @ColumnInfo(name = "trade_volume_usd")
    val tradeVolumeUsd: Double
)