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
package com.n26.database.di

import androidx.room.Room
import com.n26.database.Database
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule: Module = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            Database::class.java,
            "n26-db"
        ).fallbackToDestructiveMigration().build()
    }
}

private val daoModule: Module = module {
    single { get<Database>().statsDao() }
}

val repositoryModule: Module = module(override = true) {
    single<com.n26.domain.dbrepository.StatsRepository> { com.n26.database.repository.StatsRepositoryImpl(get()) }
}

val dataModule: List<Module> = listOf(
    databaseModule,
    daoModule,
    repositoryModule
)