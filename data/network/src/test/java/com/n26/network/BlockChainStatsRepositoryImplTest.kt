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
import com.google.gson.GsonBuilder
import com.n26.domain.model.StatsDomainModel
import com.n26.domain.netrepository.BlockChainStatsRepository
import com.n26.network.api.BlockChainAPI
import com.n26.network.di.networkModule
import com.n26.network.fakeContext
import com.n26.network.getJson
import com.n26.network.repository.BlockChainStatsRepositoryImpl
import com.n26.shared.network.NetworkResult
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.logger.Level
import org.koin.test.KoinTest
import org.koin.test.KoinTestRule
import org.koin.test.get
import org.koin.test.inject
import org.koin.test.mock.declare
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class BlockChainStatsRepositoryImplTest : KoinTest {

    private val mockWebServer = MockWebServer()

    lateinit var repo: BlockChainStatsRepository

    private val api: BlockChainAPI by inject()

    @get:Rule
    val koinTestRule = KoinTestRule.create {
        printLogger(Level.DEBUG)
        modules(networkModule + listOf(fakeContext))
    }

    @Before
    fun setup() {
        mockWebServer.start()
        declare {
            val gson = GsonBuilder()
                .serializeNulls()
                .create()

            Retrofit.Builder()
                .baseUrl(mockWebServer.url("/"))
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(get())
                .build()
        }
        repo = BlockChainStatsRepositoryImpl(api)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }

    @Test
    fun `test stats are fetched successfully`() = runBlocking {
        mockWebServer.enqueue(
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(getJson("stats.json"))
        )
        val result: NetworkResult<StatsDomainModel> = repo.fetchStats()
        assertThat(result, instanceOf(NetworkResult.Success::class.java))
    }
}