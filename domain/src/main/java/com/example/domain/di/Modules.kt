package com.example.domain.di

import com.example.domain.usecases.StatsUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

private val useCaseModule = module {
    single { StatsUseCase(get()) }
}

val domainModules: List<Module> = listOf(
    useCaseModule
)