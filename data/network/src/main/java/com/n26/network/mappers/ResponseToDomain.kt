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
package com.n26.network.mappers

import com.n26.domain.model.StatsDomainModel
import com.n26.network.models.StatsResponse

fun StatsResponse.toDomain() = StatsDomainModel(
    timestamp = timestamp,
    blocksSize = blocksSize,
    difficulty = difficulty,
    estimatedBtcSent = estimatedBtcSent,
    estimatedTransactionVolumeUsd = estimatedTransactionVolumeUsd,
    hashRate = hashRate,
    marketPrice = marketPriceUsd,
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