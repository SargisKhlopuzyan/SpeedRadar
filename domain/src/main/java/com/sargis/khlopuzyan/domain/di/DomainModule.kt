package com.sargis.khlopuzyan.domain.di

import com.sargis.khlopuzyan.domain.usecase.CurrentLocationUseCase
import org.koin.dsl.module

private val useCaseModule = module {
    single<CurrentLocationUseCase> {
        CurrentLocationUseCase(get())
    }
}

val domainModule = listOf(useCaseModule)
