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
package com.n26.domain.model

data class StatsDomainModel(
    val timestamp: Long,

    val blocksSize: Int,

    val difficulty: Long,

    val estimatedBtcSent: Long,

    val estimatedTransactionVolumeUsd: Double,

    val hashRate: Double,

    val marketPrice: Double,

    val minersRevenueBtc: Int,

    val minersRevenueUsd: Double,

    val minutesBetweenBlocks: Double,

    val nBlocksMined: Int,

    val nBlocksTotal: Int,

    val nBtcMined: Long,

    val nTx: Int,

    val nextretarget: Int,

    val totalBtcSent: Long,

    val totalFeesBtc: Long,

    val totalbc: Long,

    val tradeVolumeBtc: Double,

    val tradeVolumeUsd: Double
)