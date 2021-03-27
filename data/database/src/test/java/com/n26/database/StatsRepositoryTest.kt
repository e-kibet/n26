package com.n26.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.n26.database.repositories.StatsRepositoryImpl
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
internal class StatsRepositoryTest {

    // region Members

    private lateinit var db: BlockChainDatabase

    // endregion

    // region Test Configuration

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, BlockChainDatabase::class.java
        ).build()
    }


    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    // endregion

    // region Tests

    //TODO Check on runBlockingTest
    @Test
    fun whenWeSaveStats_ThenTheDatabaseIsUpdatedWithCorrectInfo() = runBlocking {
        // given a stats repository
        val statsRepository = createStatsRepository(database = db)

        // and a stats domain model
        val statsDomainModel = StatsDomainModelFaker.create()

        // when we save stats
        statsRepository.saveStats(data = statsDomainModel)

        // then the database is updated
        val actualDatabaseModel = statsRepository.getStats().first().first()

        Assert.assertEquals(statsDomainModel, actualDatabaseModel)
    }

    @Test
    fun whenWeFetchStats_ThenWeGetTheExpectedResults() = runBlocking {
        // given a stats repository
        val statsRepository = createStatsRepository(database = db)

        // and the expected stats
        val statOne = StatsDomainModelFaker.create(tradeVolumeBtc = 12.34)

        val expectedStats = listOf(statOne)

        // are added to the database
        statsRepository.saveStats(statOne)

        // when we fetch stats
        val actualStats = statsRepository.getStats().first()

        // then we get expected results
        Assert.assertEquals(expectedStats, actualStats)
    }

    // endregion

    // region Helper Methods

    private fun createStatsRepository(database: BlockChainDatabase) = StatsRepositoryImpl(
        database = database
    )

    // endregion
}