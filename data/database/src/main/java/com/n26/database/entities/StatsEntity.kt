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
package com.n26.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StatsEntity(
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
    val marketPrice: Double,
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