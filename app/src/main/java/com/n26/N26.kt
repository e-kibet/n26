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
package com.n26

import android.app.Application
import androidx.annotation.Nullable
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.n26.database.di.dataModule
import com.n26.domain.di.domainModules
import com.n26.network.di.networkModule
import com.n26.workers.StatsWorker
import com.n26.shared.utils.CrashlyticsTree
import org.jetbrains.annotations.NotNull
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.error.KoinAppAlreadyStartedException
import org.koin.core.logger.Level
import org.koin.core.module.Module
import timber.log.Timber
import java.util.concurrent.TimeUnit

class N26 : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
        initTimber()

        scheduleStatsWorker()
    }

    private fun scheduleStatsWorker() {
        val work = PeriodicWorkRequestBuilder<StatsWorker>(15, TimeUnit.MINUTES)
            .build()
        val workManager = WorkManager.getInstance(this)
        workManager.enqueueUniquePeriodicWork(
            STATS_WORKER,
            ExistingPeriodicWorkPolicy.REPLACE, // We wont api will give an updated value so discard
            work
        )
    }

    private fun initKoin() {
        try {
            startKoin {
                androidLogger(Level.ERROR)
                androidContext(applicationContext)
                val modules = mutableListOf<Module>().apply {
                    addAll(domainModules)
                    addAll(networkModule)
                    addAll(dataModule)
                }
                modules(modules)
            }
        } catch (error: KoinAppAlreadyStartedException) {
            Timber.e(error.localizedMessage)
        }
    }

    private fun initTimber() = when {
        BuildConfig.DEBUG -> {
            Timber.plant(object : Timber.DebugTree() {
                @Nullable
                override fun createStackElementTag(@NotNull element: StackTraceElement): String? {
                    return super.createStackElementTag(element) + ":" + element.lineNumber
                }
            })
        }
        else -> Timber.plant(CrashlyticsTree())
    }

    companion object {
        const val STATS_WORKER = "STATS_WORKER"
    }
}