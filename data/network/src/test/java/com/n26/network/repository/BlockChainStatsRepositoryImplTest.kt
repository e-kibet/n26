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
package com.n26.network.repository

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.n26.network.BaseTest
import com.n26.shared.network.NetworkResult
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(
    sdk = [Config.OLDEST_SDK],
    manifest = Config.NONE
) // https://stackoverflow.com/questions/56821193/does-robolectric-require-java-9
class BlockChainStatsRepositoryImplTest : BaseTest() {

    private lateinit var blockChainStatsRepository: BlockChainStatsRepositoryImpl

    @Before
    fun setUp() {
        super.setup()
        blockChainStatsRepository = BlockChainStatsRepositoryImpl(blockChainAPI)
    }

    @Test
    fun `test fetching blockchain prices from API`() {
        runBlocking {
            val blockchainResponse =
                blockChainStatsRepository.fetchStats()

            Truth.assertThat(blockchainResponse).isInstanceOf(NetworkResult.Success::class.java)
            (blockchainResponse as NetworkResult.Success)
            Truth.assertThat(blockchainResponse.data.blocksSize).isEqualTo(1)
        }
    }
}