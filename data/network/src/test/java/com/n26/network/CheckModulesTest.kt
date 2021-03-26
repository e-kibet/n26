package com.n26.network

import com.n26.network.di.networkModule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.test.KoinTest
import org.koin.test.check.checkModules
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class CheckModulesTest : KoinTest {

    @Test
    fun checkAllModules() = checkModules {
        modules(networkModule + fakeContext)
    }

}