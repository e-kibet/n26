package com.example.data.models


import com.google.gson.annotations.SerializedName

data class StatsResponse(
    @SerializedName("blocks_size")
    val blocksSize: Int,
    @SerializedName("difficulty")
    val difficulty: Long,
    @SerializedName("estimated_btc_sent")
    val estimatedBtcSent: Long,
    @SerializedName("estimated_transaction_volume_usd")
    val estimatedTransactionVolumeUsd: Double,
    @SerializedName("hash_rate")
    val hashRate: Double,
    @SerializedName("market_price_usd")
    val marketPriceUsd: Double,
    @SerializedName("miners_revenue_btc")
    val minersRevenueBtc: Int,
    @SerializedName("miners_revenue_usd")
    val minersRevenueUsd: Double,
    @SerializedName("minutes_between_blocks")
    val minutesBetweenBlocks: Double,
    @SerializedName("n_blocks_mined")
    val nBlocksMined: Int,
    @SerializedName("n_blocks_total")
    val nBlocksTotal: Int,
    @SerializedName("n_btc_mined")
    val nBtcMined: Long,
    @SerializedName("n_tx")
    val nTx: Int,
    @SerializedName("nextretarget")
    val nextretarget: Int,
    @SerializedName("timestamp")
    val timestamp: Double,
    @SerializedName("total_btc_sent")
    val totalBtcSent: Long,
    @SerializedName("total_fees_btc")
    val totalFeesBtc: Long,
    @SerializedName("totalbc")
    val totalbc: Long,
    @SerializedName("trade_volume_btc")
    val tradeVolumeBtc: Double,
    @SerializedName("trade_volume_usd")
    val tradeVolumeUsd: Double
)