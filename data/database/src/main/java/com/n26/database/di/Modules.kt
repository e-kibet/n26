package com.n26.database.di

import com.n26.database.BlockChainDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

val databaseModule : Module = module(override = true) {

    single {
        BlockChainDatabase.getInstance(get())
    }

}

